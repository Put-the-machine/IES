package org.put_the_machine.ies.model;

import lombok.*;

@Getter
@Setter
public class Teacher extends User {
    private Department department;
}