package com.teamarte.webarchproj2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.teamarte.webarchproj2.R;
import com.teamarte.webarchproj2.api.ApiServiceProvider;
import com.teamarte.webarchproj2.api.request.LoginRequest;
import com.teamarte.webarchproj2.api.response.AuthResponse;
import com.teamarte.webarchproj2.databinding.ActivityLoginBinding;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mBinding;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mProgressDialog =new ProgressDialog(this);
        mProgressDialog.setMessage("Logging In.......");


        mBinding.loginButton.setOnClickListener((view)->{
            String email = mBinding.emailEditText.getText().toString().trim();
            String password = mBinding.passwordEditText.getText().toString().trim();

            if(email.isEmpty()) return;
            if(password.isEmpty())return;
            login(email, password);
        });

        mBinding.registerLink.setOnClickListener(view -> {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        });
    }

    private void login(String email, String password){
        mProgressDialog.show();
        ApiServiceProvider
                .getApiService()
                .loginUser(new LoginRequest(email, password))
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        mProgressDialog.dismiss();
                        if(response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Success",Toast.LENGTH_SHORT)
                                    .show();
                        }
                        else {
                            try {
                                Toast.makeText(LoginActivity.this, response.errorBody().string().toString(),Toast.LENGTH_SHORT)
                                        .show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Timber.e(t);
                        Toast.makeText(LoginActivity.this, t.getMessage(),Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }
}
