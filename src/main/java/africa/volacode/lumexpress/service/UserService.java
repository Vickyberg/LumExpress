package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;

public interface UserService {
    LoginResponse  login(LoginRequest loginRequest);
}
