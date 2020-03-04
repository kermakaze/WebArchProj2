package com.teamarte.webarchproj2.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.teamarte.webarchproj2.R;
import com.teamarte.webarchproj2.api.ApiServiceProvider;
import com.teamarte.webarchproj2.api.response.ProfileResponse;
import com.teamarte.webarchproj2.databinding.FragmentProfileBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private FragmentProfileBinding mBinding;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);

        ApiServiceProvider.getApiService()
                .getUserDetails()
                .enqueue(new Callback<ProfileResponse>() {
                    @Override
                    public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {

                        if(response.isSuccessful()){
                            setDetails(response.body());
                        }
                        else {
                            Toast.makeText(getContext(), "Could not loaded profile", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileResponse> call, Throwable t) {

                    }
                });
        return mBinding.getRoot();
    }


    private void setDetails(ProfileResponse profileResponse){
        mBinding.fullNameEditText.setText(profileResponse.getFullName());
        mBinding.emailEditText.setText(profileResponse.getEmail());
        mBinding.phoneNumberEditText.setText(profileResponse.getPhoneNumber());
        mBinding.digitalAddressEditText.setText(profileResponse.getDigitalAddress());
        mBinding.addressEditText.setText(profileResponse.getAddress());
        mBinding.maritalStatusEditText.setText(profileResponse.getMaritalStatus());
        mBinding.employedmentStatusEditText.setText(profileResponse.getEmploymentStatus());
    }

}
