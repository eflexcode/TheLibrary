package com.larrex.thelibrary.loan.service;

import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.loan.entity.Loan;
import com.larrex.thelibrary.loan.entity.model.LoanModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LoanService {

    Loan createLoan(LoanModel loanModel,MultipartFile multipartFile);
    Loan updateLoan(LoanModel loanModel,Long id);
    Loan uploadImage(MultipartFile multipartFile, Long id) throws IOException;
    byte[] downloadImage(String filename);
    Loan getLoan (Long id);
    void deleteLoan(Long id);

}
