package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Course;

import java.util.List;

public interface CourseService {
    Course save(Course course);
    Course getById(Long id);
    Course update(Course course);
    void deleteById(Long id);

    List<Course> getCourses();
    List<Course> getCoursesByInstituteId(Long instituteId);
    List<Course> getCoursesBySubjectId(Long subjectId);
}