package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.CourseRepository;
import org.put_the_machine.ies.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository repo;

    @Override
    public Course save(Course course) {
        return repo.save(course);
    }

    @Override
    public Course update(Course course) {
        return repo.save(course);
    }

    @Override
    public Course getById(Long courseId) {
        return repo.findById(courseId).orElse(null);
    }

    @Override
    public void deleteById(Long courseId) {
        repo.deleteById(courseId);
    }

    @Override
    public List<Course> getCourses() {
        return repo.findAll();
    }

    @Override
    public List<Course> getCoursesByDepartmentId(Long departmentId) {
        return repo.findAllByDepartmentId(departmentId);
    }
}
