package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.CourseRepository;
import org.put_the_machine.ies.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repo;

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
        return repo.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found by id: " + courseId));
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
