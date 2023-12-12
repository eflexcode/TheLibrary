package com.larrex.thelibrary.auth.serviceImpl;

import com.larrex.thelibrary.auth.entity.model.Login;
import com.larrex.thelibrary.auth.entity.model.StatusMessage;
import com.larrex.thelibrary.auth.entity.model.TokenResponse;
import com.larrex.thelibrary.auth.service.AuthService;
import com.larrex.thelibrary.book.service.AuthorService;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final LiberianService liberianService;

    @Override
    public Liberian createLiberian(LiberianModel liberianModel) {

        Liberian liberian = liberianService.createLiberian(liberianModel);

        if (liberian != null){

        }

        return null;
    }

    @Override
    public StatusMessage verifyToken(String token) {
        return null;
    }

    @Override
    public StatusMessage expiredToken(String token) {
        return null;
    }

    @Override
    public TokenResponse login(Login login) {
        return null;
    }
}
