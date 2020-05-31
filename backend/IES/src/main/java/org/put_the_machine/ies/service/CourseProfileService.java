package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;

public interface CourseProfileService {
    CourseProfile save(CourseProfile courseProfile);
    CourseProfile update(CourseProfile courseProfile);
    void deleteById(Long courseProfileId);
    CourseProfile getById(Long courseProfileId);
    List<CourseProfile> getAllByCourseId(Long courseId);
}
