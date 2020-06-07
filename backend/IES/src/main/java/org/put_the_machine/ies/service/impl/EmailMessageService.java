package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.put_the_machine.ies.model.EmailMessage;
import org.put_the_machine.ies.service.NotificationEmailMessageService;
import org.put_the_machine.ies.service.UserEmailMessageService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailMessageService implements UserEmailMessageService, NotificationEmailMessageService {

    private final JavaMailSender notificationEmailSender;
    private final JavaMailSender userEmailSender;

    @Override
    public void sendUserMessage(EmailMessage message) {
        sendMessage(userEmailSender, message);
    }

    @Override
    public void sendNotificationMessage(EmailMessage message) {
        sendMessage(notificationEmailSender, message);
    }

    @SneakyThrows
    private void sendMessage(JavaMailSender sender, EmailMessage emailMessage) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(emailMessage.getFrom() + " <" + ((JavaMailSenderImpl) sender).getUsername() + ">");
        helper.setTo(emailMessage.getReceivers().get(0).getAddress());
        helper.setSubject(emailMessage.getTitle());
        helper.setText(emailMessage.getText());
        sender.send(message);
    }

}
