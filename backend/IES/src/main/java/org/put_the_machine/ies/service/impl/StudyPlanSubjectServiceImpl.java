package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.StudyPlanSubject;
import org.put_the_machine.ies.repository.StudyPlanSubjectRepository;
import org.put_the_machine.ies.service.StudyPlanSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyPlanSubjectServiceImpl implements StudyPlanSubjectService {
    @Autowired
    StudyPlanSubjectRepository repo;


    @Override
    public StudyPlanSubject save(StudyPlanSubject studyPlanSubject) {
        return repo.save(studyPlanSubject);
    }

    @Override
    public StudyPlanSubject update(StudyPlanSubject studyPlanSubject) {
        return repo.save(studyPlanSubject);
    }

    @Override
    public void deleteById(Long studyPlanSubjectId) {
        repo.deleteById(studyPlanSubjectId);
    }

    @Override
    public StudyPlanSubject getById(Long studyPlanSubjectId) {
        return repo.findById(studyPlanSubjectId).orElse(null);
    }

    @Override
    public List<StudyPlanSubject> getAllByCourseProfileId(Long courseProfileId) {
        return repo.findAllByCourseProfileId(courseProfileId);
    }
}
