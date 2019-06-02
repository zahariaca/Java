package com.zahariaca.demodbauth.model;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 02.06.2019
 */
public class AppUser {
    private Long userId;
    private String userName;
    private String encryptedPassword;

    public AppUser() {

    }

    public AppUser(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedPassword = encrytedPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public String toString() {
        return this.userName + "/" + this.encryptedPassword;
    }
}
