package com.DatNguyen.EngRisk.DataRController;

import com.DatNguyen.EngRisk.Entity.DTO.AuthenticationResponse;
import com.DatNguyen.EngRisk.Entity.DTO.LoginForm;
import com.DatNguyen.EngRisk.Entity.DTO.RegisterForm;
import com.DatNguyen.EngRisk.Entity.DTO.VocabDTO;
import com.DatNguyen.EngRisk.Service.AuthService;
import com.DatNguyen.EngRisk.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterForm registerForm){
        if (authService.registration(registerForm) != null)
            return new ResponseEntity<>(authService.registration(registerForm), HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody LoginForm loginForm){
        if (authService.authenticate(loginForm) != null)
            return new ResponseEntity<>(authService.authenticate(loginForm), HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/Contribute")
    public ResponseEntity<?>contribute(@RequestBody VocabDTO vocabDTO){
        userService.contribute(vocabDTO);
        return new ResponseEntity<>("Thanks for your contribution", HttpStatus.OK);
    }
}
