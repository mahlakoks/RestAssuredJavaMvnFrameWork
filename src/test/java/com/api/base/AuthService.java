package com.api.base;

import com.api.model.request.LoginRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService{

    private final static String BasePath="/api/auth";

    public Response getUsers(String endpoint){
        return getRequest(BasePath+endpoint);
    }

    public Response listUsers(String token,String endpoint){
        setAuthToken(token);
        return getRequest(BasePath+endpoint);
    }

    public Response login(Object payload){
        return postRequest(payload,BasePath+"/login");
    }

    public Response signUp(Object payload){
        return postRequest(payload,BasePath+"/signup");
    }

    public Response forgotPassword(String emailaddress){
        HashMap<String,String> payload=new HashMap<String,String>();
        payload.put("email",emailaddress);
        return postRequest(payload,BasePath+"/forgot-password");
    }

}
