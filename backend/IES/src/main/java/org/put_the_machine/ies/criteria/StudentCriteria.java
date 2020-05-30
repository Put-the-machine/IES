package org.put_the_machine.ies.criteria;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class StudentCriteria extends UserCriteria {
    private final Integer year;
    private final String teacherUsername;
    private final Long teacherId;
    private final String courseName;
    private final Long courseId;

    public Integer getYear() {
        return year;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public StudentCriteria(String username, String fullName, String email, Long id, Integer year, String teacherUsername, Long teacherId, String courseName, Long courseId) {
        super(username, fullName, email, id);
        this.year = year;
        this.teacherUsername = teacherUsername;
        this.teacherId = teacherId;
        this.courseName = courseName;
        this.courseId = courseId;
    }
}
