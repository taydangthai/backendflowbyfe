package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author Ly Quoc Trong
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendmail(String to, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject("Forgot Password");
            helper.setText("Hi there," +
                    "We have a request to reset password, <a href=" + content + "> click</a> to reset your password", true);
            javaMailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            log.error("Error when send mail: " + e.getMessage());
            throw new RuntimeException("Error when send mail: " + e.getMessage());
        }
    }
}
