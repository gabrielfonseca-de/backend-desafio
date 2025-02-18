package com.exemple.desafiopro.auth.service;

import com.exemple.desafiopro.auth.dto.AuthResponse;
import com.exemple.desafiopro.auth.dto.LoginRequest;
import com.exemple.desafiopro.auth.dto.RegisterRequest;
import com.exemple.desafiopro.auth.model.User;
import com.exemple.desafiopro.auth.repository.UserRepository;
import com.exemple.desafiopro.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        try {
            return AuthResponse.builder().token(jwtToken).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        var user = userRepository.findByUsernameOrEmail(request.getUsername(), request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não achado: " + request.getUsername()));

        var jwtToken = jwtService.generateToken(user); // Aqui o erro ocorre

        return AuthResponse.builder().token(jwtToken).build();
    }
}