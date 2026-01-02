package com.api.model.response;

import java.util.Arrays;

public class LoginResponse {

    private String type;
    private int  id;
    private String  username;
    private String   email;
    private String [] roles;
    private String token;

    public LoginResponse() {

    }

    public LoginResponse(String token, String[] roles, String email, String username, int id, String type) {
        this.token = token;
        this.roles = roles;
        this.email = email;
        this.username = username;
        this.id = id;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }

}
