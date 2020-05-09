package org.put_the_machine.ies.service;

import javax.security.auth.Subject;
import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    Subject updateSubject(Subject subject);

    void deleteSubjectById(Long id);

    List<Subject> getSubjectByTeacherId(Long teacherId);

    List<Subject> getSubjectByInstituteId(Long instituteId);
}