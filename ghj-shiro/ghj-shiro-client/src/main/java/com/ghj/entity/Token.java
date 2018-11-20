package com.ghj.entity;

import lombok.Data;

@Data
public class Token {

    String token;
    Boolean isValid;

    public Token(String token, Boolean isValid) {
        this.token = token;
        this.isValid = isValid;
    }

    public Token(Boolean isValid) {
        this.isValid = isValid;
    }
}
