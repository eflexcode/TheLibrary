package com.larrex.thelibrary.auth.entity.model;

import lombok.Data;

@Data
public class VerificationTokenModel {

    private String email;
    private String token;

}
