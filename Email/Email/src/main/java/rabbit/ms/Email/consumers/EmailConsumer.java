package rabbit.ms.Email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import rabbit.ms.Email.dto.EmailDTO;
import rabbit.ms.Email.model.EmailModel;
import rabbit.ms.Email.service.EmailService;

// Marks this class as a Spring-managed component, typically for handling message consumption.
@Component
public class EmailConsumer {

    // Autowires the EmailService, which will be used to send emails.
    @Autowired
    private EmailService emailService;

    // Method listens for messages from the specified RabbitMQ queue (defined in the properties file).
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenerEmailQueue(@Payload EmailDTO emailDTO) {
        var emailModel = new EmailModel();

        // Copies properties from the DTO (Data Transfer Object) to the EmailModel entity.
        // This is done to map the incoming message to the internal model used by the service.
        BeanUtils.copyProperties(emailDTO, emailModel);

        // Calls the service to send the email using the data mapped to the model.
        emailService.sendEmail(emailModel);
    }
}
