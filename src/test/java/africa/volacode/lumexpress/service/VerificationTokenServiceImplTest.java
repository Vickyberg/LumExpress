package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.exception.VerificationTokenException;
import africa.volacode.lumexpress.service.token.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class VerificationTokenServiceImplTest {

    @Autowired
    private VerificationTokenService verificationTokenService;

    private VerificationToken verificationToken;

    @BeforeEach
    void setUp(){
         verificationToken = verificationTokenService.createToken("test@gmail.com");
    }

    @Test
    void createTokenTest() {

        log.info("token->{}",verificationToken);
        assertThat(verificationToken).isNotNull();
        assertThat(verificationToken.getUserEmail()).isEqualTo("test@gmail.com");
        assertThat(verificationToken.getToken().length()).isEqualTo(5);
    }

    @Test
    void isValidVerificationTokenTest() throws VerificationTokenException {
     assertThat(verificationToken).isNotNull();
     var response = verificationTokenService.isValidVerificationToken(verificationToken.getToken());
     assertThat(response).isTrue();


    }
}