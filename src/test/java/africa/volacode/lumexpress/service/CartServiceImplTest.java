package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.service.cart.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @BeforeEach
    void setUp() {
    }

}