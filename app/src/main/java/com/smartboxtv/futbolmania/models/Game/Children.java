
package com.smartboxtv.futbolmania.models.Game;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Children {

    @SerializedName("TimeLine")
    @Expose
    private List<String> timeLine = null;
    @SerializedName("Formation")
    @Expose
    private List<String> formation = null;

    public List<String> getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(List<String> timeLine) {
        this.timeLine = timeLine;
    }

    public List<String> getFormation() {
        return formation;
    }

    public void setFormation(List<String> formation) {
        this.formation = formation;
    }

}
