package net.io.kino.service.impl;

import net.io.kino.model.Order;
import net.io.kino.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Order order, String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("kinopol.rezerwacja@gmail.com", "qykZad-rojmyz-1howfe");
//            }
//        });
//        Message msg = new MimeMessage(session);
//        try {
//            msg.setFrom(new InternetAddress("kinopol.rezerwacja@gmail.com", false));
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        try {
//            msg.setSubject("Tutorials point email");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        try {
//            msg.setContent("Tutorials point email", "text/html");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        try {
//            msg.setSentDate(new Date());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        try {
//            messageBodyPart.setContent("Tutorials point email", "text/html");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        Multipart multipart = new MimeMultipart();
//        try {
//            multipart.addBodyPart(messageBodyPart);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
////        MimeBodyPart attachPart = new MimeBodyPart();
////        attachPart.attachFile("/var/tmp/image19.png");
////        multipart.addBodyPart(attachPart);
////        msg.setContent(multipart);
//        try {
//            Transport.send(msg);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void sendEmail(String to, Order order) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);
    }
}
