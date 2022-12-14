package africa.volacode.lumexpress.service.cart;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.exception.CartNotFoundException;
import africa.volacode.lumexpress.exception.ProductNotFoundException;

import java.util.List;

public interface CartService {
    CartResponse addProductToCart(CartRequest cartRequest) throws CartNotFoundException, ProductNotFoundException;
    List<Cart> getCartList();

    Cart save(Cart cart);
}
