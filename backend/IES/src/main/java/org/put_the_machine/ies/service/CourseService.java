package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;

public interface CourseService {
    void save(Course course);
    Course getById(Long id);
    void deleteById(Long id);

    List<Course> getCourses();
    List<Course> getCoursesByDepartment(Department department);
}