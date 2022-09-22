package africa.volacode.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRegistrationRequest {
    private String country;
    private String email;
    private String password;
}
