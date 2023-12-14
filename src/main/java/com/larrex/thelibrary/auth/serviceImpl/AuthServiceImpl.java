package com.larrex.thelibrary.auth.serviceImpl;

import com.larrex.thelibrary.Util;
import com.larrex.thelibrary.auth.entity.VerificationToken;
import com.larrex.thelibrary.auth.entity.model.Login;
import com.larrex.thelibrary.auth.entity.model.StatusMessage;
import com.larrex.thelibrary.auth.entity.model.TokenResponse;
import com.larrex.thelibrary.auth.entity.model.VerificationTokenModel;
import com.larrex.thelibrary.auth.service.AuthService;
import com.larrex.thelibrary.auth.service.VerificationService;
import com.larrex.thelibrary.book.service.AuthorService;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final LiberianService liberianService;
    private final VerificationService verificationService;

    @Override
    public Liberian createLiberian(LiberianModel liberianModel) {

        Liberian liberian = liberianService.createLiberian(liberianModel);

        if (liberian != null) {
            VerificationTokenModel verificationTokenModel = new VerificationTokenModel();
            verificationTokenModel.setEmail(liberian.getEmail());
            verificationTokenModel.setToken(UUID.randomUUID().toString());
            verificationTokenModel.setExp_date(new Date(System.currentTimeMillis()+ Util.exp_time));

            verificationService.createToken(verificationTokenModel);
        }

        return liberian;
    }

    @Override
    public StatusMessage verifyToken(String token) {

        VerificationToken verificationToken = verificationService.getByToken(token);
        if (verificationToken.getExp_date().before(new Date()) ) {
            return new StatusMessage("Verification token expired");
        }
        Liberian liberian = liberianService.getLiberianByEmail(verificationToken.getEmail());
        LiberianModel liberianModel = new LiberianModel();
        liberianModel.setEnabled(true);
        liberianService.updateLiberian(liberianModel, liberian.getId());
        return new StatusMessage("Verification successful you can now login");
    }

    @Override
    public StatusMessage expiredToken(String token) {

        VerificationToken verificationToken = verificationService.getByToken(token);
        VerificationTokenModel verificationTokenModel = new VerificationTokenModel();
        verificationTokenModel.setToken(UUID.randomUUID().toString());
        verificationService.updateToken(verificationTokenModel, verificationToken.getId());

        return new StatusMessage("New Verification sent to: "+verificationToken.getEmail());
    }

    @Override
    public TokenResponse login(Login login) {
        return null;
    }

}
