package rabbit.ms.Email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rabbit.ms.Email.model.EmailModel;

import java.util.UUID;

public interface IEmailRepository extends JpaRepository<EmailModel, UUID> {
}
