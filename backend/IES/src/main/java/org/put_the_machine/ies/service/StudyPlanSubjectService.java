package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;

public interface StudyPlanSubjectService {
    StudyPlanSubject save(StudyPlanSubject studyPlanSubject);

    StudyPlanSubject update(StudyPlanSubject studyPlanSubject);

    void deleteById(Long id);
    StudyPlanSubject getById(Long id);

    List<StudyPlanSubject> getAllByCourseProfileId(Long courseProfileId);
}
