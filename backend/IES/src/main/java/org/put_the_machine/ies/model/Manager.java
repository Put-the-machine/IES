package org.put_the_machine.ies.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Manager extends User {
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Institute institute;
}