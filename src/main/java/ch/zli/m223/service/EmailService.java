package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ch.zli.m223.model.Mitglied;

@ApplicationScoped
public class EmailService {

    @Inject
    private Session mailSession;

    @Produces
    public Session produceMailSession() {
        return mailSession;
    }

    public void sendBookingConfirmationEmail(Mitglied mitglied) throws MessagingException {
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("isuf.hasani@student.ksh.ch"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mitglied.getEmail()));
        message.setSubject("Buchungsbestätigung");
        message.setText("Vielen Dank für Ihre Buchung.");

        Transport.send(message);
    }
}