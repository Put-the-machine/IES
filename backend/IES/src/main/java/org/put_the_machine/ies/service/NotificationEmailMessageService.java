package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.EmailMessage;
import org.springframework.scheduling.annotation.Async;

public interface NotificationEmailMessageService {
    @Async
    void sendNotificationMessage(EmailMessage message);
}
