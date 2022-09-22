package africa.volacode.lumexpress.data.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerRegistrationResponse {
    private String message;
    private int code;
}
