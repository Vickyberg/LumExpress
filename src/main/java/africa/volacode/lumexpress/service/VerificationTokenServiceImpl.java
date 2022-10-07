package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.models.VerificationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{
    @Override
    public VerificationToken generateToken() {
        return null;
    }
}
