package org.put_the_machine.ies.controller;


import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.CourseProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course_profile")
public class CourseProfileController {
    @Autowired
    CourseProfileService service;

    @PostMapping("save")
    public void save(@RequestBody CourseProfile courseProfile) {
        service.save(courseProfile);
    }

    @DeleteMapping("delete")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("get")
    public CourseProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("get_all_by_course")
    public List<CourseProfile> getById(@PathVariable Course course) {
        return service.getAllByCourse(course);
    }
}
