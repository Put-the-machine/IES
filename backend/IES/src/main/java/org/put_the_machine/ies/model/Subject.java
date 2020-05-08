package org.put_the_machine.ies.model;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private List<Course> courses;
    private Integer year;
    private Teacher teacher;
    private Long id;
}
