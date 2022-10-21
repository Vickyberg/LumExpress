package africa.volacode.lumexpress.service.cart;

import africa.volacode.lumexpress.data.dtos.request.CartRequest;
import africa.volacode.lumexpress.data.dtos.response.CartResponse;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.data.models.Item;
import africa.volacode.lumexpress.data.models.Product;
import africa.volacode.lumexpress.data.repository.CartRepository;
import africa.volacode.lumexpress.exception.CartNotFoundException;
import africa.volacode.lumexpress.exception.ProductNotFoundException;
import africa.volacode.lumexpress.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductService productService;

    @Override
    public CartResponse addProductToCart(CartRequest cartRequest) throws CartNotFoundException, ProductNotFoundException {
        Cart cart =cartRepository.findById(cartRequest.getCartId())
                .orElseThrow(()->new CartNotFoundException(String.format("cart with id %d not found",cartRequest.getCartId())));
       Product foundProduct = productService.getProductById(cartRequest.getProductId());
       Item item = buildCartItem(foundProduct);
       cart.getItems().add(item);
       Cart cartToSave = updateCartSubTotal(cart);
      Cart savedCart = cartRepository.save(cart);

        return CartResponse.builder()
                .message("item added to cart")
                .cart(savedCart)
                .build();
    }

    @Override
    public List<Cart> getCartList() {
        var cartList = cartRepository.findAll();
        return cartList;
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    private Item buildCartItem(Product foundProduct) {
        return Item.builder()
                .products(foundProduct)
                .quantity(1)
                .build();
    }

    private    Cart updateCartSubTotal(Cart cart){
        cart.getItems()
                .forEach(item -> sumCartItemPrices(cart, item));
        return cart;
    }

    private void sumCartItemPrices(Cart cart, Item item) {
        var itemPrice = item.getProducts().getPrice().add(cart.getSubTotal());
        cart.setSubTotal(itemPrice.add(cart.getSubTotal()));
    }
}
