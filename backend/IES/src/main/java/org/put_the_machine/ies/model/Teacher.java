package org.put_the_machine.ies.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Teacher extends User {
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Subject> subjects;
}