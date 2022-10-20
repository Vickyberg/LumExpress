package africa.volacode.lumexpress.service.customer;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.models.Customer;

import java.util.List;


public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest);
    String updateProfile(UpdateCustomerDetails updateCustomerDetails);

    List<Customer> getAllCustomers();
}
