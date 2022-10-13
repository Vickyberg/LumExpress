package africa.volacode.lumexpress.service.notifications;

import africa.volacode.lumexpress.data.dtos.request.EmailNotificationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class GmailNotificationImplTest {

    @Autowired
    private EmailNotificationService emailSender;


    @Test
    void sendHtmlMailTest() {
        EmailNotificationRequest emailDetails = new EmailNotificationRequest();
        emailDetails.setUserEmail("akinnusivictor098@gmail.com");
        emailDetails.setMailContent("Hi, Olamide!!");
        String response = emailSender.sendHtmlMail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();
    }
}