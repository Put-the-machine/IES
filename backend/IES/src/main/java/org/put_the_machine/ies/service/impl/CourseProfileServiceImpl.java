package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.CourseProfile;
import org.put_the_machine.ies.repository.CourseProfileRepository;
import org.put_the_machine.ies.service.CourseProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourseProfileServiceImpl implements CourseProfileService {
    private final CourseProfileRepository repo;

    @Override
    public CourseProfile save(CourseProfile courseProfile) {
        return repo.save(courseProfile);
    }

    @Override
    public CourseProfile update(CourseProfile courseProfile) {
        return repo.save(courseProfile);
    }

    @Override
    public void deleteById(Long courseProfileId) {
        repo.deleteById(courseProfileId);
    }

    @Override
    public CourseProfile getById(Long courseProfileId) {
        return repo.findById(courseProfileId)
                .orElseThrow(() -> new NoSuchElementException("CourseProfile not found by id: " + courseProfileId));
    }

    @Override
    public List<CourseProfile> getAllByCourseId(Long courseId) {
        return repo.findAllByCourseId(courseId);
    }
}
