package org.put_the_machine.ies.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.put_the_machine.ies.model.Course;
import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"subjectGroups", "groups"}, callSuper = true)
public class Student extends User {
    private Integer year;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SubjectGroup> subjectGroups;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Group> groups;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.STUDENT);
    }
}

