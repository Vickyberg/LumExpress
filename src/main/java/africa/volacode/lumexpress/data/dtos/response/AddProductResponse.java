package africa.volacode.lumexpress.data.dtos.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateProductResponse {
    private Long productId;
    private String message;
    private int code;
}
