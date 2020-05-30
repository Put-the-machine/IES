package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Subject;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository
        extends CrudRepository<Subject, Long>, JpaSpecificationExecutor<Subject> {

}
