package africa.volacode.lumexpress.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerDetails {

    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String imageUrl;
}
