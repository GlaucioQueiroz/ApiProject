package br.com.glaucioqueiroz.APIProject.CrossCutting.Security;

import br.com.glaucioqueiroz.APIProject.ViewModel.UserViewModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.json.JSONObject;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthentication extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_TIME_EXPIRES = 600_000;
    public static final String TOKEN_PASSWORD = "463408a1-54c9-4307-bb1c-6cced559f5a7";

    private final AuthenticationManager authenticationManager;

    public JWTAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UserViewModel usuario = new ObjectMapper().readValue(request.getInputStream(), UserViewModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getLogin(),
                    usuario.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JWTUserDetailsData usuarioData = (JWTUserDetailsData) authResult.getPrincipal();

        Date expires_in  = new Date(System.currentTimeMillis() + TOKEN_TIME_EXPIRES);

        String token = JWT.create()
                .withSubject(usuarioData.getUsername())
                .withExpiresAt(expires_in)
                .sign(Algorithm.HMAC512(TOKEN_PASSWORD));

        JSONObject json = new JSONObject();
        json.append("Token", token);
        json.append("ExpiresIn", TOKEN_TIME_EXPIRES);

        response.getWriter().write(json.toString());
        response.getWriter().flush();
    }
}