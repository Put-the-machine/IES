package org.put_the_machine.ies.specification;

import lombok.val;
import org.put_the_machine.ies.model.user.Teacher;
import org.put_the_machine.ies.criteria.TeacherCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeacherSpecification implements Specification<Teacher> {

    private final UserSpecification userSpecification;

    private final String departmentName;
    private final Long departmentId;
    private final String studentUsername;
    private final Long studentId;

    public TeacherSpecification(TeacherCriteria criteria) {
        this.userSpecification = new UserSpecification(criteria);
        this.departmentName = criteria.getDepartmentName();
        this.departmentId = criteria.getDepartmentId();
        this.studentUsername = criteria.getStudentUsername();
        this.studentId = criteria.getStudentId();
    }

    @Override
    public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        val userPredicate = userSpecification.toGenericPredicate(root, criteriaQuery, criteriaBuilder);
        List<Predicate> predicates = new ArrayList<>();

        if (departmentName != null) {
            predicates.add(criteriaBuilder.like(root.get("department").get("name"), "%" + departmentName + "%"));
        }
        if (departmentId != null) {
            predicates.add(criteriaBuilder.equal(root.get("department").get("id"), departmentId));
        }
        if (studentUsername != null) {
            predicates.add(criteriaBuilder.like(root.get("student").get("username"), "%" + studentUsername + "%"));
        }
        if (studentId != null) {
            predicates.add(criteriaBuilder.equal(root.get("student").get("id"), studentId));
        }

        val teacherPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        return criteriaBuilder.and(userPredicate, teacherPredicate);
    }
}
