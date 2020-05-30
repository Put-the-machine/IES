package org.put_the_machine.ies.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Administrator extends User {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(UserAuthority.ADMIN);
    }
}