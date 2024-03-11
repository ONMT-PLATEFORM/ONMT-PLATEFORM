package ma.onmt.api.usersservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.usersservice.dto.BearerToken;
import ma.onmt.api.usersservice.dto.LoginDto;
import ma.onmt.api.usersservice.dto.RegisterDto;
import ma.onmt.api.usersservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BearerToken> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(userService.register(registerDto));
    }

    @PostMapping("/authenticate")
    public BearerToken authenticate(@RequestBody LoginDto loginDto) {
        return userService.authenticate(loginDto);
    }


    //: FORGOT PASSWORD
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword() {
        return ResponseEntity.ok("Welcome! This is a public content!");
    }

    //: RESET PASSWORD
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword() {
        return ResponseEntity.ok("Welcome! This is a public content!");
    }
}