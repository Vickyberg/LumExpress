package africa.volacode.lumexpress.service.cart;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.data.models.Cart;

import java.util.List;

public interface CartService {
    CartResponse addProductToCart(CartRequest cartRequest);
    List<Cart> getCartList();

    Cart save(Cart cart);
}
