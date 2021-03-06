package com.unesco.core.controller;

import com.unesco.core.dto.account.UserDTO;
import com.unesco.core.dto.additional.ResponseStatusDTO;
import com.unesco.core.dto.enums.StatusTypes;
import com.unesco.core.dto.news.NewsDTO;
import com.unesco.core.managers.news.newsManager.interfaces.news.INewsManager;
import com.unesco.core.managers.news.newsManager.interfaces.newsList.INewsListManager;
import com.unesco.core.services.accessControlService.IAccessControlService;
import com.unesco.core.services.dataService.newsService.INewsDataService;
import com.unesco.core.services.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NewsController {

    @Autowired
    private INewsDataService newsDataService;
    @Autowired
    private INewsManager newsManager;
    @Autowired
    private INewsListManager newsListManager;

    @Autowired
    private IAccessControlService accessСontrolService;
    @Autowired
    private IUserService userService;

    public ResponseStatusDTO getAllNews() {
        newsListManager.init(newsDataService.getAll());
        newsListManager.SortDesc();
        return new ResponseStatusDTO(StatusTypes.OK, newsListManager.getAll());
    }

    public ResponseStatusDTO getLast() {
        newsListManager.init(newsDataService.getAll());
        newsListManager.SortDesc();
        return new ResponseStatusDTO(StatusTypes.OK, newsListManager.GetLast());
    }

    public ResponseStatusDTO get(long id) {
        newsManager.init(newsDataService.get(id));
        return new ResponseStatusDTO(StatusTypes.OK, newsManager.get());
    }

    public ResponseStatusDTO delete(long id) {
        try {
            newsDataService.delete(id);
            return new ResponseStatusDTO(StatusTypes.OK);
        }
        catch (Exception e) {
            ResponseStatusDTO result = new ResponseStatusDTO(StatusTypes.ERROR);
            if(e instanceof DataIntegrityViolationException)
                result.addErrors("Удаление не удалось. У объекта есть зависимости.");
            result.addErrors("Удаление не удалось");
            return result;
        }
    }

    public ResponseStatusDTO save(UserDTO user, NewsDTO news) {
        Date day = new Date();
        news.setDate(day);
        news.setAuthor(user);
        newsManager.init(news);
        ResponseStatusDTO result = newsManager.validate();
        if(result.getStatus() != StatusTypes.OK) return result;
        try {
            newsDataService.save(news);
            return new ResponseStatusDTO(StatusTypes.OK);
        }
        catch (Exception e) {
            return new ResponseStatusDTO(StatusTypes.ERROR, e.getMessage());
        }
    }
}
