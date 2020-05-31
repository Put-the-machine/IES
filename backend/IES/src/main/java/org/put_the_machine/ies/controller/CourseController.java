package org.put_the_machine.ies.controller;

import lombok.*;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("courses")
    public Course save(@ModelAttribute Course course) {
        return courseService.save(course);
    }

    @PutMapping("courses")
    public Course update(@ModelAttribute Course course) {
        return courseService.update(course);
    }

    @DeleteMapping("courses/{course_id}")
    public void deleteById(@PathVariable("course_id") Long courseId) {
        courseService.deleteById(courseId);
    }

    @GetMapping("courses/{id}")
    public Course getById(@PathVariable("course_id") Long courseId) {
        return courseService.getById(courseId);
    }

    @GetMapping("courses")
    public List<Course> getAll() {
        return courseService.getCourses();
    }

    @GetMapping("departments/{department_id}/courses")
    public List<Course> getAllByDepartment(@PathVariable("department_id") Long departmentId) {
        return courseService.getCoursesByDepartmentId(departmentId);
    }
}
