package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.Department;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
    List<Course> findAllByDepartmentId(Long departmentId);
}