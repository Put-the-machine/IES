package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Subject;
import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectGroupService {
    SubjectGroup save(SubjectGroup subjectGroup);

    SubjectGroup update(SubjectGroup subjectGroup);

    SubjectGroup getById(Long subjectGroupId);

    void deleteById(Long subjectGroupId);

    List<SubjectGroup> getAllBySubjectIdAndStudentId(Long subjectId, Long studentId);
}
