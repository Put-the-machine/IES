package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.CourseProfile;
import org.put_the_machine.ies.repository.CourseProfileRepository;
import org.put_the_machine.ies.service.CourseProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseProfileServiceImpl implements CourseProfileService {
    @Autowired
    CourseProfileRepository repo;

    @Override
    public void save(CourseProfile courseProfile) {
        repo.save(courseProfile);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CourseProfile getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<CourseProfile> getAllByCourse(Course course) {
        return repo.findAllByCourse(course);
    }
}
