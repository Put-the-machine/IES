package org.put_the_machine.ies.model.user;

import lombok.*;
import org.put_the_machine.ies.model.Department;
import org.put_the_machine.ies.model.DocumentMetaInfo;
import org.put_the_machine.ies.model.Subject;
import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Getter
@Setter
public class Teacher extends User {
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SubjectGroup> subjectGroups;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.TEACHER);
    }
}