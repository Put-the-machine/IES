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

    @DeleteMapping("course_profiles/{course_id}")
    public void deleteById(@PathVariable("course_id") Long courseProfileId) {
        service.deleteById(courseProfileId);
    }

    @GetMapping("course_profiles/{course_profile_id}")
    public CourseProfile getById(@PathVariable("course_profile_id") Long courseProfileId) {
        return service.getById(courseProfileId);
    }

    @GetMapping("courses/{course_id}/course_profiles")
    public List<CourseProfile> getAllByCourse(@PathVariable("course_id") Long courseId) {
        return service.getAllByCourseId(courseId);
    }
}
