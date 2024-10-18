package rabbit.ms.Email.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rabbit.ms.Email.enums.StatusEmail;
import rabbit.ms.Email.model.EmailModel;
import rabbit.ms.Email.repository.IEmailRepository;

import java.time.LocalDateTime;

// Marks this class as a service in the Spring context.
@Service
public class EmailService {

    // Injects the repository for performing CRUD operations on the EmailModel.
    @Autowired
    private IEmailRepository iEmailRepository;

    // Injects the JavaMailSender, responsible for sending emails using Spring's mail abstraction.
    @Autowired
    private JavaMailSender javaMailSender;

    // Injects the sender's email (the application's configured email) from properties.
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    // Marks the method as transactional, meaning any database operations will be part of the same transaction.
    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        try {
            // Sets the current date and time as the email's send timestamp.
            emailModel.setSendDateEmail(LocalDateTime.now());

            // Sets the email sender's address (the application’s email).
            emailModel.setEmailFrom(emailFrom);

            // Creates a simple mail message to send via email.
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            // Sets the recipient's email address.
            simpleMailMessage.setTo(emailModel.getEmailTo());

            // Sets the subject of the email.
            simpleMailMessage.setSubject(emailModel.getSubject());

            // Sets the body content of the email.
            simpleMailMessage.setText(emailModel.getText());

            // Sends the email.
            javaMailSender.send(simpleMailMessage);

            // If the email is successfully sent, updates the status to SENT.
            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            // If an exception occurs during the sending process, sets the status to ERROR.
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            // Saves the email record to the database, whether successful or not.
            return iEmailRepository.save(emailModel);
        }
    }
}
