package com.larrex.thelibrary.loan.controller;

import com.larrex.thelibrary.loan.entity.Loan;
import com.larrex.thelibrary.loan.entity.model.LoanModel;
import com.larrex.thelibrary.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("loan/v1")
@RequiredArgsConstructor
public class LoanController {


//    Loan createLoan(LoanModel loanModel, MultipartFile multipartFile);
//    Loan updateLoan(LoanModel loanModel,Long id);
//    Loan uploadImage(MultipartFile multipartFile, Long id) throws IOException;
//    byte[] downloadImage(String filename);
//    Loan getLoan (Long id);
//    void deleteLoan(Long id);

    private final LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Loan createLoan(@RequestPart(name = "image") MultipartFile multipartFile, @RequestPart(name = "body") LoanModel loanModel) {
        return loanService.createLoan(loanModel, multipartFile);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Loan updateLoan(@PathVariable(name = "id") Long id, @RequestBody LoanModel loanModel) {
        return loanService.updateLoan(loanModel, id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Loan uploadImage(@PathVariable(name = "id") Long id, @RequestParam(name = "image") MultipartFile multipartFile) throws IOException {
        return loanService.uploadImage(multipartFile, id);
    }

    @GetMapping("/profile/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable(name = "filename") String filename) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(loanService.downloadImage(filename));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Loan getLoan(@PathVariable(name = "id") Long id) {
        return loanService.getLoan(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLoan(@PathVariable(name = "id") Long id) {
        loanService.deleteLoan(id);
    }
}
