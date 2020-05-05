package org.put_the_machine.ies.filter;

import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
public abstract class UserFilter {
    private final String username;
    private final String fullname;
    private final String email;
    private final Long id;

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public Optional<String> getFullname() {
        return Optional.ofNullable(fullname);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }
}
