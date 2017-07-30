package com.smartboxtv.futbolmania.Utils;

import android.content.Context;
import android.content.SharedPreferences;



public class Preferences {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "TokenPref";

    //Keys values
    public static final String KEY_TOKEN = "name";
    public static final String KEY_VALID = "KEY_VALID_LEF";


    //Constructor
    public Preferences(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    public boolean setValid(Boolean valid){
        return prefs.getBoolean(KEY_VALID, valid);
    }

    //Metodos set and get
    public void setToken(String toke){
        editor.putString(KEY_TOKEN, toke);
        editor.commit();
    }

    public String getToken(){
        return prefs.getString(KEY_TOKEN, "0.0.0");
    }

    public Boolean isValid(){
        return prefs.getBoolean(KEY_VALID, false);
    }


}
