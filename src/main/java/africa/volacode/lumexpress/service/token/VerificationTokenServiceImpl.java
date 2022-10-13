package africa.volacode.lumexpress.service.token;

import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.data.repository.VerificationTokenRepository;
import africa.volacode.lumexpress.exception.VerificationTokenException;
import africa.volacode.lumexpress.util.LumExpressUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{


    private VerificationTokenRepository verificationTokenRepository;
    @Override
    public VerificationToken createToken(String userEmail) {
        String tokenString = LumExpressUtils.generateToken();
        VerificationToken token = VerificationToken.builder()
                .token(tokenString)
                .userEmail(userEmail)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))
                .build();
        return verificationTokenRepository.save(token);
    }

    @Override
    public boolean isValidVerificationToken(String token) {

        VerificationToken verificationToken = verificationTokenRepository.findByToken(token)
                .orElseThrow(()-> new VerificationTokenException("token not found"));
        if(isTokenNotExpired(verificationToken)) return true;
        throw new VerificationTokenException("token has expired");
    }

    private boolean isTokenNotExpired(VerificationToken verificationToken) {
        return LocalDateTime.now().isBefore(verificationToken.getExpiresAt());
    }
}
