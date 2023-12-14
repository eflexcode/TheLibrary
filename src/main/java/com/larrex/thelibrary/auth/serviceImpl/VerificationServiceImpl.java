package com.larrex.thelibrary.auth.serviceImpl;

import com.larrex.thelibrary.auth.entity.VerificationToken;
import com.larrex.thelibrary.auth.entity.model.VerificationTokenModel;
import com.larrex.thelibrary.auth.repository.VerificationTokenRepository;
import com.larrex.thelibrary.auth.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class VerificationServiceImpl implements VerificationService {

    private final VerificationTokenRepository tokenRepository;

    @Override
    public VerificationToken createToken(VerificationTokenModel model) {

        VerificationToken token = new VerificationToken();
        BeanUtils.copyProperties(model, token);

        return tokenRepository.save(token);
    }

    @Override
    public VerificationToken updateToken(VerificationTokenModel verificationTokenModel, Long id) {

        VerificationToken verificationToken =getById(id);
       verificationToken.setToken(verificationTokenModel.getToken() != null ? verificationTokenModel.getToken() : verificationToken.getToken());
       verificationToken.setEmail(verificationTokenModel.getEmail() != null ? verificationTokenModel.getEmail() : verificationToken.getEmail());

        return tokenRepository.save(verificationToken);
    }

    @Override
    public VerificationToken getById(Long id) {
        return tokenRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public VerificationToken getByToken(String token) {
        return tokenRepository.findByToken(token).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        tokenRepository.deleteById(id);
    }
}
