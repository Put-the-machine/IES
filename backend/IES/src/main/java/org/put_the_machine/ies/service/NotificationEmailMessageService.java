package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.EmailMessage;

import javax.mail.MessagingException;

public interface NotificationEmailMessageService {
    void sendNotificationMessage(EmailMessage message) throws MessagingException;
}
