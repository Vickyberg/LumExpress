package africa.volacode.lumexpress.data.dtos.response;



import lombok.*;

import java.math.BigDecimal;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class UpdateProductResponse {
    private String message;
    private int statusCode;
    private String productName;
    private String description;
    private BigDecimal price;
}
