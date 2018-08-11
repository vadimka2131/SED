package com.unesco.core.managers.journal.VisitationConfigManager;

import com.unesco.core.dto.additional.ResponseStatusDTO;
import com.unesco.core.dto.journal.VisitationConfigDTO;
import com.unesco.core.dto.shedule.LessonDTO;
import com.unesco.core.managers.journal.VisitationConfigManager.interfaces.IVisitationConfigManager;
import com.unesco.core.utils.StatusTypes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class VisitationConfigManager implements IVisitationConfigManager {

    VisitationConfigDTO visitConfig;

    public VisitationConfigManager() {
        visitConfig = new VisitationConfigDTO();
    }

    public void init(VisitationConfigDTO config)
    {
        this.visitConfig = config;
    }

    public List<Date> GetDates()
    {
        return  visitConfig.getDates();
    }

    public ResponseStatusDTO validate() {

        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO();
        responseStatusDTO.setStatus(StatusTypes.OK);

        if(!visitConfig.isAutoGenerated() &&
                (visitConfig.getDates() == null || visitConfig.getDates().isEmpty())) {
            responseStatusDTO.setStatus(StatusTypes.ERROR);
            responseStatusDTO.addErrors("Не указаны дни отметок посещения.");
        }

        return responseStatusDTO;
    }

    public void SetDeafaultConfig() {
        visitConfig = new VisitationConfigDTO();
        visitConfig.setAutoGenerated(true);
        visitConfig.setValue(1);
    }

    public void SetLesson(LessonDTO lesson) {
        visitConfig.setLesson(lesson);
    }

    public VisitationConfigDTO get() {
        if(visitConfig == null)
        {
            SetDeafaultConfig();
        }
        return visitConfig;
    }

}