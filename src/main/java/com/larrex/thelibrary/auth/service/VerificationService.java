package com.larrex.thelibrary.auth.service;

import com.larrex.thelibrary.auth.entity.VerificationToken;
import com.larrex.thelibrary.auth.entity.model.VerificationTokenModel;

public interface VerificationService {

    VerificationToken createToken(VerificationTokenModel model);

    VerificationToken updateToken(VerificationTokenModel verificationTokenModel, Long id);

    VerificationToken getById(Long id);
    VerificationToken getByToken(String token);
    void delete(Long id);

}
