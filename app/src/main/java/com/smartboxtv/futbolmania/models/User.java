package com.smartboxtv.futbolmania.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("rbac")
    @Expose
    private Rbac rbac;
    @SerializedName("profile")
    @Expose
    private Profile profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rbac getRbac() {
        return rbac;
    }

    public void setRbac(Rbac rbac) {
        this.rbac = rbac;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
