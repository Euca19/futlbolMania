package com.smartboxtv.futbolmania.models.Authenticate;

import android.os.Parcel;
import android.os.Parcelable;



public class AppModel implements Parcelable {
    private String version;



    //Constructor
    public AppModel(String version) {
        this.version = version;
    }



    //Metodos get an set
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.version);
    }

    protected AppModel(Parcel in) {
        this.version = in.readString();
    }

    public static final Parcelable.Creator<AppModel> CREATOR = new Parcelable.Creator<AppModel>() {
        @Override
        public AppModel createFromParcel(Parcel source) {
            return new AppModel(source);
        }

        @Override
        public AppModel[] newArray(int size) {
            return new AppModel[size];
        }
    };
}
