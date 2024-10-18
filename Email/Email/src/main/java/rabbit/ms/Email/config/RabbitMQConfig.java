package rabbit.ms.Email.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Marks the class as a configuration class that defines beans for Spring's ApplicationContext.
@Configuration
public class RabbitMQConfig {

    // Injects the value of the queue name from the application properties (broker.queue.email.name).
    @Value("${broker.queue.email.name}")
    private String queue;

    // Defines a bean that creates a RabbitMQ queue.
    @Bean
    public Queue queue() {
        // The second parameter "true" means that the queue is durable. If the broker restarts,
        // the queue will persist and not be lost.
        return new Queue(queue, true);
    }

    // Defines a bean that converts RabbitMQ messages to JSON format using Jackson.
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();  // ObjectMapper is used to handle JSON conversion.
        return new Jackson2JsonMessageConverter(objectMapper);  // Converter for serializing/deserializing messages.
    }
}
