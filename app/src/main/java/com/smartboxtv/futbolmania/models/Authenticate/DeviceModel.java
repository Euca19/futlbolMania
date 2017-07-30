package com.smartboxtv.futbolmania.models.Authenticate;

import android.os.Parcel;
import android.os.Parcelable;



public class DeviceModel implements Parcelable {
    String deviceId;
    String name;
    String version;
    String width;
    String heigth;
    String model;
    String platform;


    //Constructor
    public DeviceModel(String deviceId, String name, String version, String width, String heigth, String model, String platform) {
        this.deviceId = deviceId;
        this.name = name;
        this.version = version;
        this.width = width;
        this.heigth = heigth;
        this.model = model;
        this.platform = platform;
    }



    //Metodos get an set
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceId);
        dest.writeString(this.name);
        dest.writeString(this.version);
        dest.writeString(this.width);
        dest.writeString(this.heigth);
        dest.writeString(this.model);
        dest.writeString(this.platform);
    }

    protected DeviceModel(Parcel in) {
        this.deviceId = in.readString();
        this.name = in.readString();
        this.version = in.readString();
        this.width = in.readString();
        this.heigth = in.readString();
        this.model = in.readString();
        this.platform = in.readString();
    }

    public static final Parcelable.Creator<DeviceModel> CREATOR = new Parcelable.Creator<DeviceModel>() {
        @Override
        public DeviceModel createFromParcel(Parcel source) {
            return new DeviceModel(source);
        }

        @Override
        public DeviceModel[] newArray(int size) {
            return new DeviceModel[size];
        }
    };
}
