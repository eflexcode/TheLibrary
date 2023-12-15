package com.larrex.thelibrary.auth.controller;

import com.larrex.thelibrary.auth.entity.model.StatusMessage;
import com.larrex.thelibrary.auth.entity.model.TokenResponse;
import com.larrex.thelibrary.auth.service.AuthService;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.auth.entity.model.Login;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Liberian registerUser(@RequestBody LiberianModel liberianModel){
        return authService.createLiberian(liberianModel);
    }

    @PostMapping("/verify_token")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StatusMessage verifyToken(@RequestParam(name = "token") String token){
        return authService.verifyToken(token);
    }

    @PostMapping("/expired_token")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StatusMessage expiredToken(@RequestParam(name = "old_token") String token){
        return authService.expiredToken(token);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TokenResponse login(@RequestBody Login login) throws DisabledException, BadCredentialsException {
        return authService.login(login);
    }
}
