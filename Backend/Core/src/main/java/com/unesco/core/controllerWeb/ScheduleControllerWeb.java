package com.unesco.core.controllerWeb;

import com.unesco.core.controller.ScheduleController;
import com.unesco.core.dto.additional.ResponseStatusDTO;
import com.unesco.core.dto.shedule.PairParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/shedule")
public class ScheduleControllerWeb {
    @Autowired
    private ScheduleController sheduleController;

    @RequestMapping("/department/{id}/pairs")
    public ResponseStatusDTO getDepartmentPairs(@PathVariable("id") long departmentId) {
        return sheduleController.getDepartmentPairs(departmentId);
    }

    @RequestMapping("/group/{id}/pairs")
    public ResponseStatusDTO getGroupPairs(@PathVariable("id") long groupId) {
        return sheduleController.getGroupPairs(groupId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pair/{id}")
    public ResponseStatusDTO getPair(@PathVariable("id") long pairId) {
        return sheduleController.getPair(pairId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pair/{id}")
    public ResponseStatusDTO deletePair(@PathVariable("id") long pairId) {
        return sheduleController.deletePair(pairId);
    }

    @RequestMapping("/professor/{id}/pairs")
    public ResponseStatusDTO getProfessorPairs(@PathVariable("id") long professorId) {
        return sheduleController.getProfessorPairs(professorId);
    }

    @RequestMapping("/lesson/{lessonId}/pairs")
    public ResponseStatusDTO getLessonPairs(@PathVariable("lessonId") long lessonId) {
        return sheduleController.getLessonPairs(lessonId);
    }

    @RequestMapping("/professor/{professorId}/lessons")
    public ResponseStatusDTO getByProfessorId(@PathVariable("professorId") long professorId) {
        return sheduleController.getLessonsForProfessor(professorId);
    }

    @RequestMapping("/group/{groupId}/lessons")
    public ResponseStatusDTO getByPGroupId(@PathVariable("groupId") long groupId) {
        return sheduleController.getLessonsForGroup(groupId);
    }

    @RequestMapping("/pair/save")
    public ResponseStatusDTO savePair(@RequestBody PairParameters param) {
        return sheduleController.savePair(param.getPairModel(), param.isSkipWarnings());
    }

    @RequestMapping("/week/prity")
    public ResponseStatusDTO getPrityWeek() {
        return sheduleController.getPrityWeek();
    }
}

