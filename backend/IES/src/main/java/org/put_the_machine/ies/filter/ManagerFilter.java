package org.put_the_machine.ies.filter;

import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
public class ManagerFilter extends UserFilter {
    private final String instituteName;
    private final Long instituteId;

    public Optional<String> getInstituteName() {
        return Optional.ofNullable(instituteName);
    }

    public Optional<Long> getInstituteId() {
        return Optional.ofNullable(instituteId);
    }
}
