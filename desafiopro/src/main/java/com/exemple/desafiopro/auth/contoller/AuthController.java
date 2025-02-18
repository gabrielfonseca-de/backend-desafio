package com.exemple.desafiopro.auth.contoller;

import com.exemple.desafiopro.auth.dto.AuthResponse;
import com.exemple.desafiopro.auth.dto.LoginRequest;
import com.exemple.desafiopro.auth.dto.RegisterRequest;
import com.exemple.desafiopro.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
