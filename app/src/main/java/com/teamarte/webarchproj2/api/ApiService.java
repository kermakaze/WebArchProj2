package com.teamarte.webarchproj2.api;

import com.teamarte.webarchproj2.api.request.RegisterRequest;
import com.teamarte.webarchproj2.api.response.AuthResponse;
import com.teamarte.webarchproj2.api.request.LoginRequest;
import com.teamarte.webarchproj2.api.response.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;


public interface ApiService {
    //Auth
    @POST("/login")
    Call<AuthResponse> loginUser(@Body LoginRequest authRequest);

    @POST("/register")
    Call<RegistrationResponse> registerUser(@Body RegisterRequest authRequest);





}

