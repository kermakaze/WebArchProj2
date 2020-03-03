package com.teamarte.webarchproj2.api.request;

public class LoginRequest {
    private String email, password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
