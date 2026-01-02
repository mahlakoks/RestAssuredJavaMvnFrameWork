package com.api.tests;

import com.api.base.AuthService;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class ForgotPasswordTest {

    @Test(description = "Verify if forgot password is working")
    public void forgotPassword(){
        AuthService authService=new AuthService();
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        Response response=authService.forgotPassword(email);

        response.prettyPrint();
        JsonPath jsonResponse=response.jsonPath();
        String message = jsonResponse.getString("message");
        Assert.assertEquals(message,"If your email exists in our system, you will receive reset instructions.");
    }
}
//3:19