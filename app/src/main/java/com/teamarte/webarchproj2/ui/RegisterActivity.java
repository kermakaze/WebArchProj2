package com.teamarte.webarchproj2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.teamarte.webarchproj2.R;
import com.teamarte.webarchproj2.api.ApiServiceProvider;
import com.teamarte.webarchproj2.api.request.RegisterRequest;
import com.teamarte.webarchproj2.api.response.RegistrationResponse;
import com.teamarte.webarchproj2.databinding.ActivityRegisterBinding;

import java.io.IOException;
import java.util.SplittableRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;

    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Creating account....");
        mBinding.registerButton.setOnClickListener(view->{

            String email = mBinding.emailEditText.getText().toString();
            String password = mBinding.passwordEditText.getText().toString();
            String fullName = mBinding.nameEditText.getText().toString();
            String phoneNumber = mBinding.phoneNumberEditText.getText().toString();
            registerUser(new RegisterRequest(fullName,email,phoneNumber,password));
        });
    }

    private void registerUser(RegisterRequest registerRequest){

        mProgressDialog.show();
        ApiServiceProvider.getApiService()
                .registerUser(registerRequest)
                .enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                        mProgressDialog.dismiss();
                        if(response.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,
                                    "Registration Successful", Toast.LENGTH_SHORT)
                                    .show();

                            Intent i = new Intent(RegisterActivity.this, DataCollectionActivity.class);
                            RegisterActivity.this.startActivity(i);


                        }
                        else {

                            try {
                                Toast.makeText(RegisterActivity.this,
                                        response.errorBody().string(),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                        mProgressDialog.dismiss();
                    }
                });
    }
}
