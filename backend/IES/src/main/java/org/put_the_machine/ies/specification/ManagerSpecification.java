package org.put_the_machine.ies.specification;

import lombok.val;
import org.put_the_machine.ies.model.user.Manager;
import org.put_the_machine.ies.criteria.ManagerCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ManagerSpecification implements Specification<Manager> {

    private final UserSpecification userSpecification;

    private final String instituteName;
    private final Long instituteId;

    public ManagerSpecification(ManagerCriteria criteria) {
        userSpecification = new UserSpecification(criteria);
        instituteName = criteria.getInstituteName();
        instituteId = criteria.getInstituteId();
    }

    @Override
    public Predicate toPredicate(Root<Manager> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        val userPredicate = userSpecification.toGenericPredicate(root, criteriaQuery, criteriaBuilder);
        List<Predicate> predicates = new ArrayList<>();
        if (instituteId != null) {
            predicates.add(criteriaBuilder.equal(root.get("institute").get("id"), instituteId));
        }
        if (instituteName != null) {
            predicates.add(criteriaBuilder.equal(root.get("institute").get("name"), "%" + instituteName + "%"));
        }
        val managerPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        return criteriaBuilder.and(userPredicate, managerPredicate);
    }
}
