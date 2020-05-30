package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailMessageService implements UserEmailMessageService, NotificationEmailMessageService {

    @Autowired
    JavaMailSender notificationEmailSender;
    @Autowired
    JavaMailSender userEmailSender;

    @Override
    public void sendUserMessage(EmailMessage message) throws MessagingException {
        sendMessage(userEmailSender, message);
    }

    @Override
    public void sendNotificationMessage(EmailMessage message) throws MessagingException {
        sendMessage(notificationEmailSender, message);
    }

    private void sendMessage(JavaMailSender sender, EmailMessage emailMessage) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(emailMessage.getFrom() + " <" + ((JavaMailSenderImpl) sender).getUsername() + ">");
        helper.setTo(emailMessage.getReceivers().get(0).getAddress());
        helper.setSubject(emailMessage.getTitle());
        helper.setText(emailMessage.getText());
        sender.send(message);
    }

}
