package com.larrex.thelibrary.auth.service;

import com.larrex.thelibrary.auth.entity.model.Login;
import com.larrex.thelibrary.auth.entity.model.StatusMessage;
import com.larrex.thelibrary.auth.entity.model.TokenResponse;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    Liberian createLiberian(LiberianModel liberianModel);


    StatusMessage verifyToken(String token);

    StatusMessage expiredToken(String token);

    TokenResponse login(Login login);
}
