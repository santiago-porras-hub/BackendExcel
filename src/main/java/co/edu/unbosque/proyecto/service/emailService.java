package co.edu.unbosque.proyecto.service;

import co.edu.unbosque.proyecto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class emailService {
    //Importante hacer la inyección de dependencia de JavaMailSender:
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String content, String from) {

        try {
            System.out.println(to);
            System.out.println(from);
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(content);
            email.setFrom(from);
            mailSender.send(email);

        } catch (MailException e) {
            System.out.println("ESA MONDA NO SIRVE" + e.getMessage());
        }

    }


}
