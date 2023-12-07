package com.larrex.thelibrary.loan.entity.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoanModel {

    private Long liberianId;

    private Long bookId;
    private String studentName;
    private String studentAddress;
    private String studentImage;
    private Long studentClassNumber;

}
