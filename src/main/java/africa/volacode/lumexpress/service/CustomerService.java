package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;
import org.springframework.stereotype.Service;



public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    String completeProfile(UpdateCustomerDetails updateCustomerDetails);
}
