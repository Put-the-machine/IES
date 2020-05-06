package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Institute;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface InstituteRepository extends CrudRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {
}