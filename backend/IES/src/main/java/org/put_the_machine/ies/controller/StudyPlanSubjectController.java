package org.put_the_machine.ies.controller;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.StudyPlanSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/study_plan_subject")
public class StudyPlanSubjectController {
    @Autowired
    StudyPlanSubjectService service;

    @PostMapping("save")
    public void save(@RequestBody StudyPlanSubject studyPlanSubject) {
        service.save(studyPlanSubject);
    }

    @PostMapping("delete")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("get")
    public StudyPlanSubject getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("get_by_institute")
    public List<StudyPlanSubject> getByInstitute(@PathVariable CourseProfile courseProfile) {
        return service.getAllByCourseProfile(courseProfile);
    }
}
