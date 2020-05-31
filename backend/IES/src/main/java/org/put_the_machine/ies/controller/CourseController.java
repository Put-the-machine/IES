package org.put_the_machine.ies.controller;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("save")
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @DeleteMapping("delete")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping("get")
    public Course getById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @GetMapping("get_all")
    public List<Course> getAll() {
        return courseService.getCourses();
    }

    @GetMapping("get_all_by_department")
    public List<Course> getAllByDepartment(@PathVariable Department department) {
        return courseService.getCoursesByDepartment(department);
    }
}
