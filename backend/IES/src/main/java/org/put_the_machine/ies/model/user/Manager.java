package org.put_the_machine.ies.model.user;

import lombok.*;
import org.put_the_machine.ies.model.Institute;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@EqualsAndHashCode(exclude = {"institute"}, callSuper = true)
public class Manager extends User {
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Institute institute;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.MANAGER);
    }
}