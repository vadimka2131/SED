package com.unesco.core.services.dataService.journal.lessonEvent;

import com.unesco.core.entities.journal.LessonEventEntity;
import com.unesco.core.dto.journal.LessonEventDTO;
import com.unesco.core.repositories.account.ProfessorRepository;
import com.unesco.core.repositories.journal.LessonEventRepository;
import com.unesco.core.services.dataService.mapperService.IMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonEventDataService implements ILessonEventDataService {

    @Autowired
    private IMapperService mapperService;
    @Autowired
    private LessonEventRepository lessonEventRepository;

    public List<LessonEventDTO> getAll()
    {
        List<LessonEventDTO> modelList = new ArrayList<>();
        Iterable<LessonEventEntity> entityList = lessonEventRepository.findAll();
        for (LessonEventEntity item: entityList) {
            LessonEventDTO model = (LessonEventDTO) mapperService.toDto(item);
            modelList.add(model);
        }
        return modelList;
    }

    public LessonEventDTO get(long id)
    {
        LessonEventEntity entity = lessonEventRepository.findOne(id);
        LessonEventDTO model = (LessonEventDTO) mapperService.toDto(entity);
        return model;
    }

    public List<LessonEventDTO> getByLesson(long lessonId)
    {

        List<LessonEventDTO> modelList = new ArrayList<>();
        Iterable<LessonEventEntity> entityList = lessonEventRepository.findByLessonEntityId(lessonId);
        for (LessonEventEntity item: entityList) {
            LessonEventDTO model = (LessonEventDTO) mapperService.toDto(item);
            modelList.add(model);
        }
        return modelList;
    }

    public void delete(long id)
    {
        lessonEventRepository.delete(id);
    }

    public LessonEventDTO save(LessonEventDTO lessonEvent)
    {
        LessonEventEntity entity = (LessonEventEntity) mapperService.toEntity(lessonEvent);
        entity = lessonEventRepository.save(entity);
        lessonEvent = (LessonEventDTO) mapperService.toDto(entity);
        return lessonEvent;
    }
}