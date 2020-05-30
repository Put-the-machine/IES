package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.EmailMessage;

import javax.mail.MessagingException;

public interface UserEmailMessageService {
    void sendUserMessage(EmailMessage message) throws MessagingException;
}
