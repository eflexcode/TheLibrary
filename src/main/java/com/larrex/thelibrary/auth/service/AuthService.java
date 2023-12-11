package com.larrex.thelibrary.auth.service;

import com.larrex.thelibrary.auth.entity.model.Login;
import com.larrex.thelibrary.auth.entity.model.StatusMessage;
import com.larrex.thelibrary.auth.entity.model.TokenResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {


    StatusMessage verifyToken(String token);

    StatusMessage expiredToken(String token);

    TokenResponse login(Login login);
}
