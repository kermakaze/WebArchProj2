package com.teamarte.webarchproj2.api.response;

import com.google.gson.annotations.SerializedName;

public class GenericResponse {
    @SerializedName("success")
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
