
package com.smartboxtv.futbolmania.models.Game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name_ {

    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("original")
    @Expose
    private String original;

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

}
