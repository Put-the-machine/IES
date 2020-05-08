package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Subject;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SubjectRepository {
    Subject save(Subject subject);

    Subject findById(Long id);

    Subject update(Subject subject);

    void deleteById(Long id);

    List<Subject> findAll(Specification<Subject> specification);
}
