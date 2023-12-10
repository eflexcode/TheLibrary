package com.larrex.thelibrary.auth.controller;

import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
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

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody LiberianModel liberianModel){

        return new ResponseEntity<String>(authService.registerUser(userWrapper), HttpStatus.CREATED);
    }

    @PostMapping("verifyToken")
    public ResponseEntity<String> verifyToken(@RequestParam(name = "token") String token){

        return new ResponseEntity<String>(authService.verifyToken(token),HttpStatus.OK);

    }

    @PostMapping("expiredToken")
    public ResponseEntity<String> expiredToken(@RequestParam(name = "old_token") String token){
        return new ResponseEntity<String>(authService.expiredToken(token),HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody Login login) throws DisabledException, BadCredentialsException {

        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userService.userDetailService().loadUserByUsername(login.getEmail());
        return new ResponseEntity<JwtResponse>(new JwtResponse(jwtUtils.generateToken(userDetails)),HttpStatus.OK);
    }

}
