package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.SignupRequest;
import com.api.model.response.AccountCreationErrorResponse;
import com.api.model.response.LoginResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class AccountCreationTest {

    @Test(description = "Verify account creation")
    public void accountCreation(){

        Faker faker=new Faker();
       String password=faker.name().firstName();
      String email=faker.internet().emailAddress();
        SignupRequest signupRequest=new SignupRequest.Builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(email)
                .userName(faker.name().username())
                .password(password)
                .mobileNumber(faker.phoneNumber().subscriberNumber(10))
                .build();

  System.out.println(signupRequest.toString());

    AuthService authService=new AuthService();
        Response  response=authService.signUp(signupRequest);//loginResponse.getToken(),
    response.prettyPrint();

    if(response.statusCode()!=200) {
        AccountCreationErrorResponse accountCreationErrorResponse=response.as(AccountCreationErrorResponse.class);
        Assert.assertEquals(response.statusCode(),500);
        Assert.assertEquals(accountCreationErrorResponse.getSolution(),"Please try again later or contact support");
    }

    if(response.statusCode()==200){
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");

    }

}
}
