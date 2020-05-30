package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.CourseProfile;
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
    public void save(StudyPlanSubject studyPlanSubject) {
        repo.save(studyPlanSubject);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public StudyPlanSubject getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<StudyPlanSubject> getAllByCourseProfile(CourseProfile courseProfile) {
        return repo.findAllByCourseProfile(courseProfile);
    }
}
