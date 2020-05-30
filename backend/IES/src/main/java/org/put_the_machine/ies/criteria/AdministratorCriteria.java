package org.put_the_machine.ies.criteria;


import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AdministratorCriteria extends UserCriteria {
    public AdministratorCriteria(String username, String fullName, String email, Long id) {
        super(username, fullName, email, id);
    }
}
