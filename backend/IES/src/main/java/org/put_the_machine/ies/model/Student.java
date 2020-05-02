package org.put_the_machine.ies.model;

import lombok.*;
import org.put_the_machine.ies.model.User;

@Getter
@Setter
public class Student extends User {
    private int year;
}
