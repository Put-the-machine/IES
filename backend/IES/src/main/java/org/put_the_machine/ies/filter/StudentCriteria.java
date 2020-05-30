package org.put_the_machine.ies.filter;

import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
public class StudentCriteria extends UserCriteria {
    private final Integer year;
    private final String teacherUsername;
    private final Long teacherId;
    private final String courseName;
    private final Long courseId;

    public Optional<Integer> getYear() {
        return Optional.ofNullable(year);
    }

    public Optional<String> getTeacherUsername() {
        return Optional.ofNullable(teacherUsername);
    }

    public Optional<Long> getTeacherId() {
        return Optional.ofNullable(teacherId);
    }

    public Optional<String> getCourseName() {
        return Optional.ofNullable(courseName);
    }

    public Optional<Long> getCourseId() {
        return Optional.ofNullable(courseId);
    }
}
