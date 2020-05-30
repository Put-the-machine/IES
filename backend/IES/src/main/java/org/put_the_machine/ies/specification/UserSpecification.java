package org.put_the_machine.ies.specification;

import org.put_the_machine.ies.criteria.UserCriteria;
import org.put_the_machine.ies.model.user.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {

    private final String username;
    private final String fullName;
    private final String email;
    private final Long id;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return toGenericPredicate(root, criteriaQuery, criteriaBuilder);
    }

    protected <T extends User> Predicate toGenericPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (username != null) {
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + username + "%"));
        }
        if (fullName != null) {
            predicates.add(criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%"));
        }
        if (email != null) {
            predicates.add(criteriaBuilder.like(root.get("email").get("address"), "%" + email + "%"));
        }
        if (id != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    public UserSpecification(UserCriteria criteria) {
        this.username = criteria.getUsername();
        this.fullName = criteria.getFullName();
        this.email = criteria.getEmail();
        this.id = criteria.getId();
    }
}
