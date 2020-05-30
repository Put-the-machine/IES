package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.CourseRepository;
import org.put_the_machine.ies.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository repo;

    @Override
    public void save(Course course) {
        repo.save(course);
    }

    @Override
    public Course getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return repo.findAll();
    }

    @Override
    public List<Course> getCoursesByDepartment(Department department) {
        return repo.findAllByDepartment(department);
    }
}
