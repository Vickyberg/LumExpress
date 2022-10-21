package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;
import africa.volacode.lumexpress.data.models.LumExpressUser;
import africa.volacode.lumexpress.exception.UserNotFoundException;

import java.util.Optional;

public interface UserService {
    LoginResponse  login(LoginRequest loginRequest);
    LumExpressUser getUserByUsername(String email) throws UserNotFoundException;
}
