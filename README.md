# Microserviço de Envio de E-mails

Este microserviço é responsável por ouvir mensagens de uma fila do RabbitMQ e enviar e-mails de confirmação para os usuários.

## Tecnologias Utilizadas

- **Java**: 17
- **Spring Boot**: Última versão
- **RabbitMQ**: Utiliza CloudAMQP
- **Gmail SMTP**: Para envio de e-mails

## Pré-requisitos

1. **Java 17**: Certifique-se de que o Java 17 está instalado em sua máquina.
2. **Conta no CloudAMQP**: Crie uma conta e configure seu RabbitMQ na [CloudAMQP](https://www.cloudamqp.com/).
3. **Configuração do Gmail**: Para enviar e-mails, você precisará configurar a senha de aplicativo. Consulte as instruções [aqui](https://support.google.com/accounts/answer/185833?hl=pt-BR).

## Configuração do RabbitMQ e E-mail

No arquivo `src/main/resources/application.properties`, atualize as seguintes configurações:

```properties
# Configurações do RabbitMQ
spring.rabbitmq.addresses=Seu_Link_CloudAMQP

# Configurações do e-mail
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=SeuEmail@gmail.com
spring.mail.password=Sua_Senha_Do_App
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Microserviço de cadastrar usuário
[Repositório](https://github.com/euvitorti/Microservico-Cadastrar-Usuario)

## Contribuições
Sinta-se à vontade para contribuir para o projeto! Qualquer feedback é bem-vindo.
