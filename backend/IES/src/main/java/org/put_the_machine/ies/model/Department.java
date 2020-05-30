package org.put_the_machine.ies.model;

import lombok.*;
import org.put_the_machine.ies.model.user.Teacher;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"institute", "teachers", "courses"})
@ToString(exclude = {"institute", "teachers", "courses"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Institute institute;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department" , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Teacher> teachers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department" , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Course> courses;

}

