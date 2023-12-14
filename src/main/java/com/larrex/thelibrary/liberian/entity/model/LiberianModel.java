package com.larrex.thelibrary.liberian.entity.model;

import lombok.Data;

@Data
public class LiberianModel {

    private String fullName;
    private String email;
    private String password;
    private String imageUrl;
    private Boolean enabled;
}
