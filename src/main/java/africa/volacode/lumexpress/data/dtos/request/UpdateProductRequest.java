package africa.volacode.lumexpress.data.dtos.request;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    private Long productId;
    private BigDecimal price;
    private int quantity;
    private String description;

}
