package org.put_the_machine.ies.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private String username;
    private String fullName;
    private Email email;
    private String password;
    private Long id;
}

