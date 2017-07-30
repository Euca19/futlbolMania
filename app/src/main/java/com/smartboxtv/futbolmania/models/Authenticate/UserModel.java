package com.smartboxtv.futbolmania.models.Authenticate;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;



public class UserModel implements Parcelable {
    HashMap profile;


    //construtor
    public UserModel(HashMap profile) {
        this.profile  = profile;
    }


    //Metodos set and get
    public HashMap getProfile() {
        return profile;
    }
    public void setProfile(HashMap profile) {
        this.profile = profile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.profile);
    }

    protected UserModel(Parcel in) {
        this.profile = (HashMap) in.readSerializable();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
