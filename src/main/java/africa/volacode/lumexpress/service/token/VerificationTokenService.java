package africa.volacode.lumexpress.service.token;

import africa.volacode.lumexpress.data.models.VerificationToken;

public interface VerificationTokenService {
    VerificationToken createToken(String email);
    boolean isValidVerificationToken(String token);
}
