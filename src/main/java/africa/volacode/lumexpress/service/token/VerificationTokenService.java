package africa.volacode.lumexpress.service.token;

import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.exception.VerificationTokenException;

public interface VerificationTokenService {
    VerificationToken createToken(String email);
    boolean isValidVerificationToken(String token) throws VerificationTokenException;
}
