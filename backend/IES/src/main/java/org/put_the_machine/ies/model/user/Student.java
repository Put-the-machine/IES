package org.put_the_machine.ies.model.user;

import lombok.*;
import org.put_the_machine.ies.model.Course;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Getter
@Setter
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.STUDENT);
    }
}

