package com.ghj.authority;

import javax.persistence.*;

@Table(name = "ghj_authority_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String usercode;

    private String username;

    private String password;

    private String salt;

    private Integer locked;

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
     * @return usercode
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * @param usercode
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return locked
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }
}