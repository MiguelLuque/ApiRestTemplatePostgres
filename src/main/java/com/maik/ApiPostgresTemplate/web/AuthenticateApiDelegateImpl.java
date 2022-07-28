package com.maik.ApiPostgresTemplate.web;

import com.maik.ApiPostgresTemplate.api.AuthApiDelegate;
import com.maik.ApiPostgresTemplate.config.JwtTokenUtil;
import com.maik.ApiPostgresTemplate.domain.entities.User;
import com.maik.ApiPostgresTemplate.models.dto.AuthRequest;
import com.maik.ApiPostgresTemplate.models.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticateApiDelegateImpl implements AuthApiDelegate {

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtTokenUtil;
    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        AuthResponse response = new AuthResponse();
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(), authRequest.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String accessToken = jwtTokenUtil.generateAccessToken(user);

        response.setEmail(user.getEmail());
        response.setToken(accessToken);

        return ResponseEntity.ok().body(response);
    }
}
