package africa.volacode.lumexpress.service.token;

import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.util.LumExpressUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{
    @Override
    public VerificationToken createToken(String userEmail) {
        String tokenString = LumExpressUtils.generateToken();
        VerificationToken verificationToken = VerificationToken.builder()
                .token(tokenString)
                .userEmail(userEmail)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))
                .build();
        return verificationToken;
    }
}
