package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Subject;
import org.put_the_machine.ies.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("subjects")
    Subject create(@ModelAttribute Subject subject) {
        return subjectService.save(subject);
    }

    @GetMapping("subjects/{subjectId}")
    Subject getById(@PathVariable Long subjectId) {
        return subjectService.getById(subjectId);
    }

    @PutMapping("subjects")
    void update(@ModelAttribute Subject subject) {
        subjectService.update(subject);
    }

    @DeleteMapping("subjects/{subjectId}")
    void delete(@PathVariable Long subjectId) {
        subjectService.deleteById(subjectId);
    }

}
