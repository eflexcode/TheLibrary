package com.larrex.thelibrary.loan.service;

import com.larrex.thelibrary.loan.entity.Loan;
import com.larrex.thelibrary.loan.entity.model.LoanModel;

public interface LoanService {

    Loan createLoan(LoanModel loanModel);
    Loan updateLoan(LoanModel loanModel,Long id);
    Loan getLoan (Long id);
    void deleteLoan(Long id);

}
