package com.larrex.thelibrary.liberian.serviceImpl;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.repository.LiberianRepository;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LiberianServiceImpl implements LiberianService {

    private final LiberianRepository liberianRepository;

    @Override
    public Liberian createLiberian(LiberianModel liberianModel) {

        Liberian liberian = new Liberian();
        BeanUtils.copyProperties(liberianModel,liberian);

        return liberianRepository.save(liberian);
    }

    @Override
    public Liberian updateLiberian(LiberianModel liberianModel, Long id) {

        Liberian liberian = liberianRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        liberian.setEmail(liberianModel.getEmail() != null ? liberianModel.getEmail() : liberian.getEmail());
        liberian.setPassword(liberianModel.getPassword() != null ? liberianModel.getPassword() : liberian.getPassword());
        liberian.setFullName(liberianModel.getFullName() != null ? liberianModel.getFullName() : liberian.getFullName());
        liberian.setImageUrl(liberianModel.getImageUrl() != null ? liberianModel.getImageUrl() : liberian.getImageUrl());


        return liberianRepository.save(liberian);
    }

    @Override
    public Liberian getLiberianById(Long id) {
        return liberianRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,""));
    }

    @Override
    public void delete(Long id) {

        liberianRepository.deleteById(id);

    }
}
