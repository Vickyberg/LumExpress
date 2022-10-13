package africa.volacode.lumexpress.data.dtos.request;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartRequest {
    private Long productId;
    private Long cartId;
}
