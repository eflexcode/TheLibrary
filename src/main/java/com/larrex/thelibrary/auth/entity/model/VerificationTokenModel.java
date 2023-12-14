package com.larrex.thelibrary.auth.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class VerificationTokenModel {

    private String email;
    private String token;
    private Date exp_date;


}
