package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.models.VerificationToken;

public interface VerificationTokenService {
    VerificationToken generateToken();
}
