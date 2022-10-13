package africa.volacode.lumexpress.service.cart;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;

public interface CartService {
    CartResponse addProductToCart(CartRequest cartRequest);
}
