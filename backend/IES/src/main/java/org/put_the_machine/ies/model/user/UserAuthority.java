package org.put_the_machine.ies.model.user;

import org.springframework.security.core.GrantedAuthority;

enum UserAuthority implements GrantedAuthority {
    ADMIN, STUDENT, MANAGER, TEACHER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}