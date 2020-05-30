package org.put_the_machine.ies.repository.user;

import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.model.user.Teacher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
}
