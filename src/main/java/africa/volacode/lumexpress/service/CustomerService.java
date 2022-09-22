package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
