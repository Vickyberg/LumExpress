package africa.volacode.lumexpress.service.security.filters;

import africa.volacode.lumexpress.data.models.LumExpressUser;
import africa.volacode.lumexpress.service.security.managers.CustomAuthenticationManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class LumExpressUserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //TODO: 1. create an authentication object(which contains auth credentials) that isn't authenticated
        String email =request.getParameter("username");
        String password = request.getParameter("password");
        log.info("email->{} password->{}",email,password);
        var authenticationToken = new UsernamePasswordAuthenticationToken(email,password);

        //TODO: 2. use AuthenticationManager to authenticate the use whose  auth  credentials are now contained within the authentication object


        //TODO: 3. get back the authentication object which has just been authenticated by the AuthenticationManager
        Authentication authenticatedToken = customAuthenticationManager.authenticate(authenticationToken);
        //TODO 4. store authentication in SecurityContext
        if (authenticatedToken != null){
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticationToken);
            return authenticatedToken;
        }
        throw new BadCredentialsException("oh oh!!");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    }
}
