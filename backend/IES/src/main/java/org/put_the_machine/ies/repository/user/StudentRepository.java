package org.put_the_machine.ies.repository.user;

import org.put_the_machine.ies.model.user.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>, JpaSpecificationExecutor<Student> {
}
