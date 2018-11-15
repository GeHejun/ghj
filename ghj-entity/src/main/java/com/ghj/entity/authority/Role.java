package com.ghj.entity.authority;

import com.ghj.common.model.Model;
import javax.persistence.*;

@Table(name = "ghj_authority_role")
public class Role extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer available;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return available
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }
}