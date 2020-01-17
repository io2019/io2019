package net.io.kino.service.impl;

import net.io.kino.model.Order;
import net.io.kino.model.Ticket;
import net.io.kino.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;

@Service
public class EmailSenderImpl implements EmailSender {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(order.getClient().getEmail());
        msg.setSubject("Potwierdzenie zakupu biletu");

        String emailContent = "Dzień Dobry, "+order.getClient().getName()+" "+order.getClient().getSurname()+"\n" +
                "Dziękujemy za skorzystanie z usług serwisu internetowego Kinopol. \n" +
                "Poniżej przesyłamy podsumowanie Twojej transakcji zakupu biletów. \n" +
                "Numer zamówienia: "+ order.getId()+"\n" +
                "Film: "+order.getTickets().get(0).getShowtime().getMovie().getTitle()+"\n" +
                "Data: "+order.getTickets().get(0).getShowtime().getDate().format(formatter)+"\n" +
                "Sala: "+order.getTickets().get(0).getShowtime().getShowroom().getName()+"\n" +
                "Twoje Bilety: \n";

        for (Ticket ticket: order.getTickets()
             ) {
            emailContent = emailContent + "Numer biletu: "+ticket.getId()+"\t Miejsce: " + ticket.getSeatPosition()+" \t" +
                    " Typ biletu: "+ticket.getTicketType().getName()+" \n";
            
        }

        emailContent = emailContent + "Niniejsza wiadomość jest potwierdzeniem wpływu środków za dokonany zakup. \n" +
                "Niniejsza wiadomość jest generowana automatycznie i nie należy na nią odpowiadać.";

        msg.setText(emailContent);
        javaMailSender.send(msg);
    }
}
