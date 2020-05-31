package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;

public interface CourseService {
    Course save(Course course);

    Course update(Course course);

    Course getById(Long id);
    void deleteById(Long id);

    List<Course> getCourses();
    List<Course> getCoursesByDepartmentId(Long departmentId);
}