package africa.volacode.lumexpress.service.notifications;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Email;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class GmailEmailSenderImplTest {

    @Autowired
    private EmailSender emailSender;


    @Test
    void sendHtmlMailTest() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setUserEmail("akinnusivictor098@gmail.com");
        emailDetails.setMailContent("Hi, Olamide!!");
        String response = emailSender.sendHtmlMail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();
    }
}