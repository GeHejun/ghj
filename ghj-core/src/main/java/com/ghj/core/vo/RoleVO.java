package com.ghj.core.vo;

import lombok.Data;

@Data
public class RoleVO extends BaseVO {
    private Integer id;

    private String name;

    private Integer available;
}
