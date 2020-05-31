package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.StudyPlanSubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudyPlanSubjectController {
    private final StudyPlanSubjectService service;

    @PostMapping("study_plan_subjects")
    public StudyPlanSubject save(@RequestBody StudyPlanSubject studyPlanSubject) {
        return service.save(studyPlanSubject);
    }

    @PutMapping("study_plan_subjects")
    public StudyPlanSubject update(@ModelAttribute StudyPlanSubject studyPlanSubject) {
        return service.update(studyPlanSubject);
    }

    @DeleteMapping("study_plan_subjects/{studyPlanSubjectId}")
    public void deleteById(@PathVariable Long studyPlanSubjectId) {
        service.deleteById(studyPlanSubjectId);
    }

    @GetMapping("study_plan_subjects/{studyPlanSubjectId}")
    public StudyPlanSubject getById(@PathVariable Long studyPlanSubjectId) {
        return service.getById(studyPlanSubjectId);
    }

    @GetMapping("courses/{courseProfileId}/study_plan_subjects")
    public List<StudyPlanSubject> getByInstitute(@PathVariable Long courseProfileId) {
        return service.getAllByCourseProfileId(courseProfileId);
    }
}
