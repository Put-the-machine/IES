package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.EmailMessage;
import org.put_the_machine.ies.service.UserEmailMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
public class UserEmailMessageController {
    private final UserEmailMessageService userEmailMessageService;

    @GetMapping("sendUserEmailMessage")
    public void send(@ModelAttribute EmailMessage message) throws MessagingException {
        userEmailMessageService.sendUserMessage(message);
    }
}
