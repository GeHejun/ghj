package com.ghj.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO extends BaseDTO implements Serializable {

    private String usercode;

    private String username;

    private String password;
}
