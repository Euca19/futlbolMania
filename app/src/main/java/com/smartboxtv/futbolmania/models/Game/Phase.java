
package com.smartboxtv.futbolmania.models.Game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phase {

    @SerializedName("original")
    @Expose
    private String original;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

}
