package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Email;
import org.put_the_machine.ies.model.EmailMessage;
import org.put_the_machine.ies.service.UserEmailMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEmailMessageController {
    private final UserEmailMessageService userEmailMessageService;

    @PostMapping("sendUserEmailMessage")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void send(
//            @RequestBody String[] receivers,
            @ModelAttribute("receiver") String receiver,
            @ModelAttribute("from") String from,
            @ModelAttribute("title") String title,
            @ModelAttribute("text") String text
    ) throws MessagingException {
        userEmailMessageService.sendUserMessage(EmailMessage.builder().from(from).title(title).text(text).receiver(new Email(receiver)).build());
    }
}
