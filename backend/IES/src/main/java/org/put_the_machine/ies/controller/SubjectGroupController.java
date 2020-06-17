package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.SubjectGroup;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.service.SubjectGroupService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubjectGroupController {
    private final SubjectGroupService subjectGroupService;

    @PostMapping("subject_groups")
    public SubjectGroup save(@ModelAttribute SubjectGroup subjectGroup) {
        return subjectGroupService.save(subjectGroup);
    }

    @PutMapping("subject_groups")
    public SubjectGroup update(@ModelAttribute SubjectGroup subjectGroup) {
        return subjectGroupService.update(subjectGroup);
    }

    @GetMapping("subject_groups/{subjectGroupId}")
    public SubjectGroup getById(@PathVariable Long subjectGroupId) {
        return subjectGroupService.getById(subjectGroupId);
    }

    @DeleteMapping("subject_groups/{subjectGroupId}")
    public void deleteById(@PathVariable Long subjectGroupId) {
        subjectGroupService.deleteById(subjectGroupId);
    }

    @GetMapping("subjects/{subjectId}/students/{studentId}")
    public List<SubjectGroup> getAllBySubjectIdAndStudentId(@PathVariable Long subjectId,
                                                            @PathVariable Long studentId) {
        return subjectGroupService.getAllBySubjectIdAndStudentId(subjectId, studentId);
    }
}
