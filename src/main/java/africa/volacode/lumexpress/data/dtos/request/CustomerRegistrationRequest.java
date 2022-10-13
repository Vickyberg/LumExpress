package africa.volacode.lumexpress.data.dtos.request;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CustomerRegistrationRequest {
    @NotNull(message = "country cannot be null")
    @NotEmpty(message = "country cannot be empty")
    private String country;
    @Email(message = "invalid email")
    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotNull(message = "provide name or get lost")
    @NotEmpty(message = "provide name or get lost")
    private String firstName;
    @NotNull
    @NotEmpty
    private String password;
}
