package com.larrex.thelibrary.loan.repository;


import com.larrex.thelibrary.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LoanRepository extends JpaRepository<Loan,Long> {
}
