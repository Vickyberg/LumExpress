package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.exception.CartNotFoundException;
import africa.volacode.lumexpress.exception.ProductNotFoundException;
import africa.volacode.lumexpress.service.cart.CartService;
import africa.volacode.lumexpress.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CartServiceImplTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    private Cart savedCart;

    @BeforeEach
    void setUp() {
        Cart cart = new Cart();
        savedCart = cartService.save(cart);
    }

    @Test
    @DisplayName("test that product can be added to cart")
    void addProductToCartTest() throws ProductNotFoundException, CartNotFoundException {
        CartRequest cartRequest = CartRequest.builder()
                .cartId(savedCart.getId())
                .productId(productService
                        .getAllProducts(new GetAllItemsRequest(1,1))
                        .getContent()
                        .get(productService
                                .getAllProducts(new GetAllItemsRequest(1,1))
                                .getNumberOfElements()-1).getId())
                .build();
        CartResponse cartResponse = cartService.addProductToCart(cartRequest);
        log.info("{}",cartResponse);
        assertThat(cartResponse).isNotNull();
        var cartSubTotal = cartResponse.getCart().getSubTotal();
        assertThat(cartSubTotal).isLessThan(BigDecimal.valueOf(51));
        assertThat(cartSubTotal).isGreaterThan(BigDecimal.valueOf(49.99));
    }

}