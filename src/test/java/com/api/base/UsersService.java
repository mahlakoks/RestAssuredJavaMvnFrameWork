package com.api.base;

import io.restassured.response.Response;

public class UsersService extends GoRestBaseService{

private final static String BasePath="/public/v2";

public Response getUsers(String endpoint){
    return getRequest(BasePath+endpoint);
}

    public Response listUsers(String endpoint){
        setAuthToken();
        return getRequest(BasePath+endpoint);
    }

    public Response createUser(String payload, String endpoint){
        setAuthToken();
        return postRequest(payload,BasePath+endpoint);
    }




}
