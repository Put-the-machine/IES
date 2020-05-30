package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;

public interface CourseProfileService {
    void save(CourseProfile courseProfile);
    void deleteById(Long id);
    CourseProfile getById(Long id);
    List<CourseProfile> getAllByCourse(Course course);
}
