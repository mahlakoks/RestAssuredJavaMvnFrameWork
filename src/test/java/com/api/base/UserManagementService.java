package com.api.base;

import io.restassured.response.Response;

public class UserManagementService extends  BaseService{

    private final static String BasePath="/api/users";

    public Response getProfile(String token){
        setAuthToken(token);
        return getRequest(BasePath+"/profile");
    }

    public Response updateProfile(Object payload,String token){
        setAuthToken(token);
        return putRequest(payload,BasePath+"/profile");
    }
}
