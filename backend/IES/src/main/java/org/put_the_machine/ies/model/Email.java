package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import org.put_the_machine.ies.exception.EmailValidationException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Email {
    @Transient
    @JsonIgnore
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    @JsonProperty("email")
    private String address;

    public Email(@NonNull String address) throws EmailValidationException {
        setAddress(address);
    }

    public void setAddress(@NonNull String address) throws EmailValidationException {
        if (address.matches(emailPattern)) {
            this.address = address;
        } else {
            throw new EmailValidationException("Invalid email: " + address);
        }
    }
}
