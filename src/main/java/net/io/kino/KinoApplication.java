package net.io.kino;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@SpringBootApplication
public class KinoApplication {

    public static void main(String[] args) throws IOException, MessagingException {
        sendmail();
        SpringApplication.run(KinoApplication.class, args);

    }
    static private void sendmail() throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kinopol.rezerwacja@gmail.com", "qykZad-rojmyz-1howfe");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("kinopol.rezerwacja@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("i@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        //attachPart.attachFile("/var/tmp/image19.png");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
        Transport.send(msg);
    }
    @RequestMapping(value = "/sendemail")
    static public String sendEmail() throws MessagingException, IOException {
        sendmail();
        return "Email sent successfully";
    }

    @Bean
    public Module hibernate5Module() {
        return new Hibernate5Module();
    }

}
