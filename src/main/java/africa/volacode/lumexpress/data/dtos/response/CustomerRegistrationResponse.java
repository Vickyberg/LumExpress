package africa.volacode.lumexpress.data.dtos.response;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerRegistrationResponse {

    @Id
    private  Long userId;
    private String message;
    private int code;
}
