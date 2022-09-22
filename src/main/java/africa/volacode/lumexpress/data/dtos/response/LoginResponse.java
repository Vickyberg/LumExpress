package africa.volacode.lumexpress.data.dtos.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String message;
    private int code;
}
