package org.put_the_machine.ies.controller;


import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.CourseProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseProfileController {
    private final CourseProfileService service;

    @PostMapping("course_profiles")
    public CourseProfile save(@ModelAttribute CourseProfile courseProfile) {
        return service.save(courseProfile);
    }

    @PutMapping("course_profiles")
    public CourseProfile update(@ModelAttribute CourseProfile courseProfile) {
        return service.update(courseProfile);
    }

    @DeleteMapping("course_profiles/{courseId}")
    public void deleteById(@PathVariable("courseId") Long courseProfileId) {
        service.deleteById(courseProfileId);
    }

    @GetMapping("course_profiles/{courseProfileId}")
    public CourseProfile getById(@PathVariable Long courseProfileId) {
        return service.getById(courseProfileId);
    }

    @GetMapping("courses/{courseId}/course_profiles")
    public List<CourseProfile> getAllByCourse(@PathVariable Long courseId) {
        return service.getAllByCourseId(courseId);
    }
}
