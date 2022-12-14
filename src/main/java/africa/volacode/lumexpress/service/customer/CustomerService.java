package africa.volacode.lumexpress.service.customer;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.models.Customer;
import africa.volacode.lumexpress.exception.LumExpressException;
import africa.volacode.lumexpress.exception.UserNotFoundException;

import java.util.List;


public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) throws LumExpressException;
    String updateProfile(UpdateCustomerDetails updateCustomerDetails) throws UserNotFoundException;

    List<Customer> getAllCustomers();
}
