package rabbit.ms.Email.model;

import jakarta.persistence.*;
import rabbit.ms.Email.enums.StatusEmail;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

// Marks the class as an entity that will be mapped to a database table.
@Entity
// Specifies the name of the database table as "TB_EMAILS".
@Table(name = "TB_EMAILS")
public class EmailModel implements Serializable {

    // Defines a unique identifier for serialization, useful when persisting the object's state.
    private static final long serialVersionUID = 1L;

    // Specifies that "emailId" is the primary key of the entity.
    @Id
    // Automatically generates the ID using the AUTO strategy, typically delegated to the database.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;  // UUID is used as a unique identifier.

    // Stores the ID of the user who is associated with the email, also a UUID.
    private UUID userId;

    // Sender's email address.
    private String emailFrom;

    // Recipient's email address.
    private String emailTo;

    // Subject of the email.
    private String subject;

    // Defines the "text" field as type TEXT in the database, allowing for long text content.
    @Column(columnDefinition = "TEXT")
    private String text;

    // Timestamp of when the email is sent.
    private LocalDateTime sendDateEmail;

    // Enum to track the status of the email (e.g., SENT, ERROR, etc.).
    private StatusEmail statusEmail;

    // Getters and Setters provide controlled access to the private fields.

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
