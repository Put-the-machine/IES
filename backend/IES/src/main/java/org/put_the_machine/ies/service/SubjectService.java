package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Subject;

public interface SubjectService {
    Subject save(Subject subject);

    Subject getById(Long subjectId);

    void update(Subject subject);

    void deleteById(Long subjectId);
}