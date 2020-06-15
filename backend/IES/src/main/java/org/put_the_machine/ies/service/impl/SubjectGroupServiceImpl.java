package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.SubjectGroup;
import org.put_the_machine.ies.repository.SubjectGroupRepository;
import org.put_the_machine.ies.service.SubjectGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SubjectGroupServiceImpl implements SubjectGroupService {
    private final SubjectGroupRepository subjectGroupRepository;

    @Override
    public SubjectGroup save(SubjectGroup subjectGroup) {
        return subjectGroupRepository.save(subjectGroup);
    }

    @Override
    public SubjectGroup update(SubjectGroup subjectGroup) {
        return subjectGroupRepository.save(subjectGroup);
    }

    @Override
    public SubjectGroup getById(Long subjectGroupId) {
        return subjectGroupRepository.findById(subjectGroupId)
                .orElseThrow(() -> new NoSuchElementException("There is no SubjectGroup with id = " + subjectGroupId));
    }

    @Override
    public void deleteById(Long subjectGroupId) {
            subjectGroupRepository.deleteById(subjectGroupId);
    }

    @Override
    public List<SubjectGroup> getAllBySubjectIdAndStudentId(Long subjectId, Long studentId) {
        return subjectGroupRepository.findAllBySubjectIdAndStudentId(subjectId, studentId);
    }
}
