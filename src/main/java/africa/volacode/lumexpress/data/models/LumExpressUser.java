package africa.volacode.lumexpress.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LumExpressUser {
    private String firstName;
    private String lastName;
    private  String email;
    private  String password;
    private String phoneNumber;
    private String imageUrl;
}
