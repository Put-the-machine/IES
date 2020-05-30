package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Subject;
import org.put_the_machine.ies.repository.SubjectRepository;
import org.put_the_machine.ies.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(() -> new NoSuchElementException("Subject not fount by id: " + subjectId));
    }

    @Override
    public void update(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

}
