package com.example.mailtrap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailTrapController {

    private final MailTrapService mailTrapService;

    public MailTrapController(MailTrapService mailTrapService) {
        this.mailTrapService = mailTrapService;
    }

    @GetMapping("/send")
    public String activeAccount() throws MessagingException {
        mailTrapService.sendToken();
        return "SUCCESS";
    }
}
