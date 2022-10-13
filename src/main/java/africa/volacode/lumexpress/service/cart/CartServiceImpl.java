package africa.volacode.lumexpress.service.cart;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.data.models.Item;
import africa.volacode.lumexpress.data.models.Product;
import africa.volacode.lumexpress.data.repository.CartRepository;
import africa.volacode.lumexpress.exception.CartNotFoundException;
import africa.volacode.lumexpress.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductService productService;

    @Override
    public CartResponse addProductToCart(CartRequest cartRequest) {
        Cart cart =cartRepository.findById(cartRequest.getCartId())
                .orElseThrow(()->new CartNotFoundException(String.format("cart with id %d not found",cartRequest.getCartId())));
       Product foundProduct = productService.getProductById(cartRequest.getProductId());
       Item item = buildCartItem(foundProduct);
       cart.getItems().add(item);
       cartRepository.save(cart);

        return CartResponse.builder()
                .message("item added to cart").build();
    }

    private Item buildCartItem(Product foundProduct) {
        return Item.builder()
                .products(foundProduct)
                .quantity(1)
                .build();
    }
}
