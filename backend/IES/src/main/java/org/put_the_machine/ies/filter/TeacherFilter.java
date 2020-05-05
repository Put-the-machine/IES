package org.put_the_machine.ies.filter;

import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
public class TeacherFilter extends UserFilter {
    private final String departmentName;
    private final Long departmentId;
    private final String studentUsername;
    private final Long studentId;

    public Optional<String> getDepartmentName() {
        return Optional.ofNullable(departmentName);
    }

    public Optional<Long> getDepartmentId() {
        return Optional.ofNullable(departmentId);
    }

    public Optional<String> getStudentUsername() {
        return Optional.ofNullable(studentUsername);
    }

    public Optional<Long> getStudentId() {
        return Optional.ofNullable(studentId);
    }
}
