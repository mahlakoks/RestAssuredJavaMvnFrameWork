package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UsersService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

    @Test(description = "Verify with valid credentials can get access token")
    public void LoginTest(){
        AuthService authservice=new AuthService();

        LoginRequest loginRequest=new LoginRequest("nigelthetester@live.com","Biko4u");

        Response response=authservice.login(loginRequest);


        System.out.println("===================================== ");
        response.prettyPrint();

        LoginResponse loginResponse=response.as(LoginResponse.class);

        System.out.println("?????===================================== ");
        System.out.println(loginResponse.getToken());
        System.out.println(Arrays.stream(loginResponse.getRoles()).findFirst());
        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"nigelthetester@live.com");
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
