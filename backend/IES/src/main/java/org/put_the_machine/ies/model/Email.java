package org.put_the_machine.ies.model;

import lombok.Getter;
import lombok.NonNull;
import org.put_the_machine.ies.exception.EmailValidationException;

@Getter
public class Email {
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
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
