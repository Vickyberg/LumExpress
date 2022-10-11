package africa.volacode.lumexpress.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LumExpressUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateTokenTest() {
        String token = LumExpressUtils.generateToken();
        assertThat(token).isNotNull();
        log.info("token :: {}",token);
        assertThat(token.length()).isEqualTo(5);
    }
}