package com.larrex.thelibrary.loan.serviceImpl;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookWrapper;
import com.larrex.thelibrary.book.repository.BookRepository;
import com.larrex.thelibrary.book.service.AuthorService;
import com.larrex.thelibrary.book.service.BookService;
import com.larrex.thelibrary.book.service.CategoryService;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.repository.LiberianRepository;
import com.larrex.thelibrary.liberian.service.LiberianService;
import com.larrex.thelibrary.loan.entity.Loan;
import com.larrex.thelibrary.loan.entity.model.LoanModel;
import com.larrex.thelibrary.loan.repository.LoanRepository;
import com.larrex.thelibrary.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final BookService bookService;
    private final LoanRepository loanRepository;
    private final LiberianService liberianService;


    @Override
    public Loan createLoan(LoanModel loanModel) {

        BookWrapper book = bookService.getBookById(loanModel.getBookId());
        Liberian liberian = liberianService.getLiberianById(loanModel.getLiberianId());

        Loan loan = new Loan();
        BeanUtils.copyProperties(loanModel, loan);

        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoan(LoanModel loanModel, Long id) {

        Loan loan = getLoan(id);

        if (loanModel.getBookId() != null) {
            BookWrapper book = bookService.getBookById(loanModel.getBookId());
            loan.setBookId(loanModel.getBookId());
        }

        if (loanModel.getLiberianId() != null) {
            Liberian liberian = liberianService.getLiberianById(loanModel.getLiberianId());
            loan.setLiberianId(loanModel.getLiberianId());
        }

        loan.setStudentName(loanModel.getStudentName() != null ? loanModel.getStudentName() : loan.getStudentName());
        loan.setStudentAddress(loanModel.getStudentAddress() != null ? loanModel.getStudentAddress() : loan.getStudentAddress());
        loan.setStudentImage(loanModel.getStudentImage() != null ? loanModel.getStudentImage() : loan.getStudentImage());
        loan.setStudentClassNumber(loanModel.getStudentClassNumber() != null ? loanModel.getStudentClassNumber() : loan.getStudentClassNumber());

        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoan(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteLoan(Long id) {

        loanRepository.deleteById(id);

    }
}
