package org.put_the_machine.ies.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@Getter
public class UserCriteria {
    private final String username;
    private final String fullName;
    private final String email;
    private final Long id;

}
