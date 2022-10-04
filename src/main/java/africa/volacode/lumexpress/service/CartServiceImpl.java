package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.data.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
}
