package africa.volacode.lumexpress.service.security;

import africa.volacode.lumexpress.data.models.LumExpressUser;
import africa.volacode.lumexpress.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LumExpressUser foundUser = userService.getUserByUsername(username);
    }
}
