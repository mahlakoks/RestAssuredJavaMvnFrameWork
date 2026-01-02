package com.api.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GoRestBaseService {

   private static final String  BASEURL="https://gorest.co.in";
    private final RequestSpecification requestSpecification;
    private static final String token ="5898818135bd9cfc636d3a8ef63a64588e9c313098210303da5c4285af9604";
//https://gorest.co.in/my-account/access-tokens

    public GoRestBaseService(){
        requestSpecification=given()
                .baseUri(BASEURL);
    }

    protected void setAuthToken(){
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(String payload, String endpoint){
        return requestSpecification.header("Content-Type","application/json").body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.header("Content-Type","application/json").get(endpoint);
    }


}

