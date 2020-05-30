package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyPlanSubjectRepository extends CrudRepository<StudyPlanSubject, Long> {
    List<StudyPlanSubject> findAllByCourseProfile(CourseProfile courseProfile);
}
