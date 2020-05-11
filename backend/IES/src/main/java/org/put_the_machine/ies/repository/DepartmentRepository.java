package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Department;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>, JpaSpecificationExecutor<Department> {
}
