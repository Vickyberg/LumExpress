package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.service.cart.CartService;
import africa.volacode.lumexpress.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CartServiceImplTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("test that product can be added to cart")
    void addProductToCartTest(){
        CartRequest cartRequest = CartRequest.builder()
                .cartId(cartService.getCartList().
                        get(cartService.getCartList().size()-1)
                        .getId())
                .productId(productService
                        .getAllProducts(new GetAllItemsRequest())
                        .getContent()
                        .get(productService
                                .getAllProducts(new GetAllItemsRequest(10,1))
                                .getNumberOfElements()-1).getId())
                .build();
        CartResponse cartResponse = cartService.addProductToCart(cartRequest);
        log.info("{}",cartResponse);
        assertThat(cartResponse).isNotNull();
    }

}