package org.put_the_machine.ies.specification;

import org.put_the_machine.ies.model.user.Administrator;
import org.put_the_machine.ies.criteria.AdministratorCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AdministratorSpecification implements Specification<Administrator> {

    private final UserSpecification userSpecification;

    public AdministratorSpecification(AdministratorCriteria criteria) {
        userSpecification = new UserSpecification(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Administrator> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return userSpecification.toGenericPredicate(root, criteriaQuery, criteriaBuilder);
    }
}
