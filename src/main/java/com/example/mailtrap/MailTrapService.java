package com.example.mailtrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class MailTrapService {

    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendToken() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setFrom("sender@gmail.ru");
        helper.setTo("sendTo@gmail.io");
        helper.setSubject("Verification code");
        helper.setText("<h1>html</h1>", true);
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        javaMailSender.send(mimeMessage);
    }
}
