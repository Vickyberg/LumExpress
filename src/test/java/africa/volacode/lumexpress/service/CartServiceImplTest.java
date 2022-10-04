package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.models.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private  CartService cartService;

    @BeforeEach
    void setUp() {
    }

}