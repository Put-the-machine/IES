package org.put_the_machine.ies.criteria;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TeacherCriteria extends UserCriteria {
    private final String departmentName;
    private final Long departmentId;
    private final String studentUsername;
    private final Long studentId;

    public String getDepartmentName() {
        return departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public Long getStudentId() {
        return studentId;
    }

    public TeacherCriteria(String username, String fullName, String email, Long id, String departmentName, Long departmentId, String studentUsername, Long studentId) {
        super(username, fullName, email, id);
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.studentUsername = studentUsername;
        this.studentId = studentId;
    }
}
