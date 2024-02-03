package com.DatNguyen.EngRisk.Service;

import com.DatNguyen.EngRisk.Entity.DTO.*;
import com.DatNguyen.EngRisk.Entity.config.CustomUserDetails;
import com.DatNguyen.EngRisk.Entity.config.JWTService;
import com.DatNguyen.EngRisk.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private JWTService jwtService;
    private AuthenticationManager authenticationManager;
    public AuthenticationResponse registration(RegisterForm registerForm){
        Date registerDay = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(registerDay);
        if (registerForm.getPassword().equals(registerForm.getRetypePassword())){
            if(userRepo.findByUserName(registerForm.getUserName()) == null && userRepo.findByEmail(registerForm.getEmail()) == null){
                User user = User.builder()
                        .userName(registerForm.getUserName())
                        .email(registerForm.getEmail())
                        .pass(passwordEncoder.encode(registerForm.getPassword()))
                        .role(Role.USER)
                        .joinedDate(registerDay)
                        .build();
                userRepo.save(user);
                String jwtToken = jwtService.tokenGenerator((CustomUserDetails) user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
            }
        }
        return null;
    }

    public AuthenticationResponse authenticate(LoginForm loginForm){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword()
                )
        );
        User user = userRepo.findByEmail(loginForm.getEmail());
        String jwtToken = jwtService.tokenGenerator((CustomUserDetails) user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
