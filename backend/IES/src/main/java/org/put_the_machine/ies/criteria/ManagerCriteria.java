package org.put_the_machine.ies.criteria;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ManagerCriteria extends UserCriteria {
    private final String instituteName;
    private final Long instituteId;

    public String getInstituteName() {
        return instituteName;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public ManagerCriteria(String username, String fullName, String email, Long id, String instituteName, Long instituteId) {
        super(username, fullName, email, id);
        this.instituteName = instituteName;
        this.instituteId = instituteId;
    }
}
