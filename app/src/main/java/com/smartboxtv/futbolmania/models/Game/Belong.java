
package com.smartboxtv.futbolmania.models.Game;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Belong {

    @SerializedName("Client")
    @Expose
    private String client;
    @SerializedName("AccessGroup")
    @Expose
    private List<String> accessGroup = null;
    @SerializedName("Tournament")
    @Expose
    private List<String> tournament = null;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(List<String> accessGroup) {
        this.accessGroup = accessGroup;
    }

    public List<String> getTournament() {
        return tournament;
    }

    public void setTournament(List<String> tournament) {
        this.tournament = tournament;
    }

}
