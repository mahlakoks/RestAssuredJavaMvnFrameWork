package com.api.base;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    //Swagger http://64.227.160.186:8080/swagger-ui/index.html#/Authentication/authenticateUser

   private static final String  BASEURL="http://64.227.160.186:8080";

    private final RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        requestSpecification=given()
                .baseUri(BASEURL);
    }



    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.header("Content-Type","application/json").body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.header("Content-Type","application/json").get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.header("Content-Type","application/json").body(payload).post(endpoint);
    }


}

