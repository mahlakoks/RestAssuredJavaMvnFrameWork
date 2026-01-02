package com.api.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CoreBaseService {

    private static final String  BASEURL="https://bookstore.toolsqa.com";

    private final RequestSpecification requestSpecification;

    protected CoreBaseService(String baseUrl) {
        this.requestSpecification = given()
                .baseUri(baseUrl)
                .contentType("application/json");
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

