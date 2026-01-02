package com.api.base;

import io.restassured.response.Response;

public class BookStoreService extends CoreBaseService {

    private final static String BasePath="/BookStore";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    public BookStoreService(){
        super(BASE_URL);
    }

    public Response getBooks(){
       return getRequest(BasePath+"/v1/Books");
    }

}
