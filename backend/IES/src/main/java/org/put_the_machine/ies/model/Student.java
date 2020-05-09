package org.put_the_machine.ies.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Student extends User {
    private Integer year;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getYear(), student.getYear()) &&
                Objects.equals(getCourse(), student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getCourse());
    }
}

