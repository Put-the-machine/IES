package org.put_the_machine.ies.model.user;

import lombok.*;
import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student extends User {
    private Integer year;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SubjectGroup> subjectGroups;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getYear());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.STUDENT);
    }
}

