package org.put_the_machine.ies.specification;

import lombok.val;
import org.put_the_machine.ies.model.user.Student;
import org.put_the_machine.ies.criteria.StudentCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification implements Specification<Student> {

    private final UserSpecification userSpecification;

    private final Integer year;
    private final String teacherUsername;
    private final Long teacherId;
    private final String courseName;
    private final Long courseId;

    public StudentSpecification(StudentCriteria criteria) {
        userSpecification = new UserSpecification(criteria);
        this.year = criteria.getYear();
        this.teacherUsername = criteria.getTeacherUsername();
        this.teacherId = criteria.getTeacherId();
        this.courseName = criteria.getCourseName();
        this.courseId = criteria.getCourseId();
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        val userPredicate = userSpecification.toGenericPredicate(root, criteriaQuery, criteriaBuilder);
        List<Predicate> predicates = new ArrayList<>();

        if (year != null) {
            predicates.add(criteriaBuilder.equal(root.get("year"), year));
        }
        if (teacherUsername != null) {
            predicates.add(criteriaBuilder.like(root.get("teacher").get("username"), "%" + teacherUsername + "%"));
        }
        if (teacherId != null) {
            predicates.add(criteriaBuilder.equal(root.get("teacher").get("id"), teacherId));
        }
        if (courseName != null) {
            predicates.add(criteriaBuilder.like(root.get("course").get("name"), "%" + courseName + "%"));
        }
        if (teacherId != null) {
            predicates.add(criteriaBuilder.equal(root.get("course").get("id"), courseId));
        }

        val studentPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        return criteriaBuilder.and(userPredicate, studentPredicate);
    }
}
