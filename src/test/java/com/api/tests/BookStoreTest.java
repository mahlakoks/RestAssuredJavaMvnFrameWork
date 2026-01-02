package com.api.tests;

import com.api.base.BookStoreService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class BookStoreTest {

    @Test
    public void getBooks(){
        BookStoreService bookStoreService=new BookStoreService();

        Response response=bookStoreService.getBooks();

        response.prettyPrint();
        List<Object> jsonpathrespose=response.jsonPath().getList("books");


       // BooksResponse booksResponse=response.as(BooksResponse.class);

        System.out.println(jsonpathrespose.get(0));
//        jsonpathrespose.forEach(n=>n.pa);

    }
}
