package com.smartboxtv.futbolmania.models.Authenticate;

import android.os.Parcel;
import android.os.Parcelable;



public class LoginModel implements Parcelable {
    UserModel user;
    DeviceModel device;
    AppModel app;



    //Constructor
    public LoginModel(UserModel user, DeviceModel device, AppModel app) {
        this.user = user;
        this.device = device;
        this.app = app;
    }


    //Metodos get and set
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DeviceModel device) {
        this.device = device;
    }

    public AppModel getApp() {
        return app;
    }

    public void setApp(AppModel app) {
        this.app = app;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.device, flags);
        dest.writeParcelable(this.app, flags);
    }

    protected LoginModel(Parcel in) {
        this.user = in.readParcelable(UserModel.class.getClassLoader());
        this.device = in.readParcelable(DeviceModel.class.getClassLoader());
        this.app = in.readParcelable(AppModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<LoginModel> CREATOR = new Parcelable.Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel source) {
            return new LoginModel(source);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };
}
