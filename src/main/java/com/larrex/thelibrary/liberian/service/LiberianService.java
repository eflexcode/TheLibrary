package com.larrex.thelibrary.liberian.service;

import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface LiberianService {

        Liberian createLiberian(LiberianModel liberianModel);
        Liberian updateLiberian(LiberianModel liberianModel,Long id);
        Liberian getLiberianById(Long id);
        void delete(Long id);

}
