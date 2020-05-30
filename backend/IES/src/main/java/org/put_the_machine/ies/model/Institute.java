package org.put_the_machine.ies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.put_the_machine.ies.model.user.Manager;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"managers", "departments"})
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institute", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Manager> managers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institute", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Department> departments;

}