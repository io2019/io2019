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
        StringBuilder stringBuilder = new StringBuilder();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(order.getClient().getEmail());
        msg.setSubject("Potwierdzenie zakupu biletu");

        String emailContent = String.format("Dzień Dobry, %s %s\n" +
                        "Dziękujemy za skorzystanie z usług serwisu internetowego Kinopol. \n" +
                        "Poniżej przesyłamy podsumowanie Twojej transakcji zakupu biletów. \n" +
                        "Numer zamówienia: %d\n" +
                        "Film: %s\n" +
                        "Data: %s\n" +
                        "Sala: %s\n" +
                        "Twoje Bilety: \n",
                order.getClient().getName(),
                order.getClient().getSurname(),
                order.getId(),
                order.getTickets().get(0).getShowtime().getMovie().getTitle(),
                order.getTickets().get(0).getShowtime().getDate().format(formatter),
                order.getTickets().get(0).getShowtime().getShowroom().getName());

        stringBuilder.append(emailContent);

        for (Ticket ticket: order.getTickets()
             ) {
            stringBuilder.append("Numer biletu: ").append(ticket.getId()).
                    append("\t Miejsce: ").append(ticket.getSeatPosition()).append(" \t").
                    append(" Typ biletu: ").append(ticket.getTicketType().getName()).append(" \n");
        }

        stringBuilder.append("Niniejsza wiadomość jest potwierdzeniem wpływu środków za dokonany zakup. \n" +
                "Niniejsza wiadomość jest generowana automatycznie i nie należy na nią odpowiadać.");

        msg.setText(stringBuilder.toString());
        javaMailSender.send(msg);
    }
}
