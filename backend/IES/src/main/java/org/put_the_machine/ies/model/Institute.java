package org.put_the_machine.ies.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institute", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Manager> managers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institute", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Department> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institute)) return false;
        Institute institute = (Institute) o;
        return Objects.equals(getId(), institute.getId()) &&
                Objects.equals(getName(), institute.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}