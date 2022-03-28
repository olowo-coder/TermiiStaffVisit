package com.example.termiistaffvisitor.mail;

import com.example.termiistaffvisitor.model.Staff;
import com.example.termiistaffvisitor.model.Visitor;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {

    public static void sendingEmail(Staff staff, Visitor visitor){
        String to = staff.getEmail_address();

        String from = "termii@gmail.com";

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Alert! - Visitor");

            message.setText("Hello " + staff.getStaff_name() + " you have a visitor. \n" +
                    "Name of Visitor: " + visitor.getVisitor_name());

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
