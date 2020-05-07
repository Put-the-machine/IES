package org.put_the_machine.ies.model;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String name;
    private Institute institute;
}
