package africa.volacode.lumexpress.data.repository;

import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.exception.VerificationTokenException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class VerificationTokenRepositoryTest {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private VerificationToken  verificationToken;

    @BeforeEach
    void setUp() {
        verificationToken = new VerificationToken();
        verificationToken.setToken("12345");
        verificationToken.setUserEmail("test@gmail.com");
    }

    @Test
    void findByUserEmail() {
        verificationTokenRepository.save(verificationToken);
       VerificationToken foundToken =  verificationTokenRepository
               .findByUserEmail("test@gmail.com").orElseThrow(() -> new VerificationTokenException("token not found!!!"));
       assertThat(foundToken).isNotNull();
       assertThat(foundToken.getToken()).isEqualTo(verificationToken.getToken());

    }

    @Test
    void findByToken() {
    }
}