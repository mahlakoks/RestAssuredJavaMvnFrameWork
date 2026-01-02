package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.UpdateProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.ProfileResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class UserManagementTest {

    @Test(description = "Verify user is able too get profile")
    public void getProfile(){
        AuthService authservice=new AuthService();
        LoginRequest loginRequest=new LoginRequest("nigelthetester@live.com","Biko4u");
        Response response=authservice.login(loginRequest);

        LoginResponse loginResponse=response.as(LoginResponse.class);
        UserManagementService  userManagementService=new UserManagementService();

        response=userManagementService.getProfile(loginResponse.getToken());
        System.out.println("===================================== ");
        response.prettyPrint();


        System.out.println("===================================== ");
        ProfileResponse profileResponse=response.as(ProfileResponse.class);
        System.out.println(profileResponse.getEmail());

        Assert.assertEquals(profileResponse.getMobileNumber(),"0826733144");

    }

    @Test(description = "Update profile")
    public void updateprofile(){
        // t(String firstName, String lastName, String email, String mobileNumber)
        Faker faker=new Faker();
        UpdateProfileRequest updateProfileRequest=new UpdateProfileRequest(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.phoneNumber().subscriberNumber(10));

      //  response=userManagementService.updateProfile(updateProfileRequest,loginResponse.getToken());
    }
}
