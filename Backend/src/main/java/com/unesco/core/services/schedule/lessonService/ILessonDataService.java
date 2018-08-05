package com.unesco.core.services.schedule.lessonService;

import com.unesco.core.dto.shedule.LessonDTO;
import com.unesco.core.services.IDataService;

import java.util.List;

public interface ILessonDataService extends IDataService<LessonDTO> {
    LessonDTO GetDisciplineIdAndGroupIdAndProfessorId(long disciplineId, long groupId, long professorId);
    List<LessonDTO> GetByProfessorId(long professorId);
}
