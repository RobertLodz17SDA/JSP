package pl.sdacademy.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private Properties props;
    private Session session;
    private String emailHost;
    private final String USER_NAME = "jav7ldz@gmail.com";
    private final String PASSWORD = "J4V4siedem";

    private String userToSend;
    private String addressToSend;
    private String emailContent;

    public EmailSender(String userToSend, String addressToSend, String content) {
        initProperties();
        this.userToSend = userToSend;
        this.addressToSend = addressToSend;
        this.emailContent = content;
    }

    public void send() {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addressToSend));
            message.setSubject("Confirmation of sending message to JSP Server");
            message.setText(buildConfirmationMessage());
            Transport transport = session.getTransport("smtp");

            transport.connect(emailHost, USER_NAME, PASSWORD);

            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void initProperties() {
        this.emailHost = "smtp.gmail.com";
        this.props = System.getProperties();
        this.props.put("mail.smtp.starttls.enable", "true");
        this.props.put("mail.smtp.host", this.emailHost);
        this.props.put("mail.smtp.user", this.USER_NAME);
        this.props.put("mail.smtp.password", this.PASSWORD);
        this.props.put("mail.smtp.port", "587");
        this.props.put("mail.smtp.auth", "true");
        this.session = Session.getDefaultInstance(props);
    }

    private String buildConfirmationMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello, " + userToSend + "!\n\n");
        builder.append("This is a confirmation that you have sent "
                + "the following message to the JSP server:\n\n");
        builder.append(emailContent + "\n\n");
        builder.append("Thank you, " + userToSend + "!\n");
        builder.append("JSP Server\n");

        return builder.toString();
    }
}
