package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>, JpaSpecificationExecutor<Course> {
}