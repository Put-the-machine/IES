package org.put_the_machine.ies.model;

import lombok.*;
import org.put_the_machine.ies.model.user.Student;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"students", "subjects"})
@EqualsAndHashCode(exclude = {"students", "subjects"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Subject> subjects;

}