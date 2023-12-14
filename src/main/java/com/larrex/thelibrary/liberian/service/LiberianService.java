package com.larrex.thelibrary.liberian.service;

import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface LiberianService {

        Liberian createLiberian(LiberianModel liberianModel);
        Liberian updateLiberian(LiberianModel liberianModel,Long id);
        Liberian getLiberianById(Long id);
        Liberian getLiberianByEmail(String email);

        Liberian uploadImage(MultipartFile multipartFile,Long id) throws IOException;

        byte[] downloadImage(String filename);
        void delete(Long id);

}
