
package com.smartboxtv.futbolmania.models.Game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("__belong")
    @Expose
    private Belong belong;
    @SerializedName("_externalProvider")
    @Expose
    private String externalProvider;
    @SerializedName("_externalId")
    @Expose
    private String externalId;
    @SerializedName("matchDay")
    @Expose
    private MatchDay matchDay;
    @SerializedName("eventStatus")
    @Expose
    private EventStatus eventStatus;
    @SerializedName("statusCategory")
    @Expose
    private String statusCategory;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("cellType")
    @Expose
    private Integer cellType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam awayTeam;
    @SerializedName("homeScore")
    @Expose
    private Integer homeScore;
    @SerializedName("awayScore")
    @Expose
    private Integer awayScore;
    @SerializedName("matchTime")
    @Expose
    private Integer matchTime;
    @SerializedName("homePenalties")
    @Expose
    private Object homePenalties;
    @SerializedName("awayPenalties")
    @Expose
    private Object awayPenalties;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("statusDate")
    @Expose
    private String statusDate;
    @SerializedName("_createDate")
    @Expose
    private String createDate;
    @SerializedName("__children")
    @Expose
    private Children children;
    @SerializedName("_model")
    @Expose
    private String model;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Belong getBelong() {
        return belong;
    }

    public void setBelong(Belong belong) {
        this.belong = belong;
    }

    public String getExternalProvider() {
        return externalProvider;
    }

    public void setExternalProvider(String externalProvider) {
        this.externalProvider = externalProvider;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public MatchDay getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(MatchDay matchDay) {
        this.matchDay = matchDay;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(String statusCategory) {
        this.statusCategory = statusCategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getCellType() {
        return cellType;
    }

    public void setCellType(Integer cellType) {
        this.cellType = cellType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Integer matchTime) {
        this.matchTime = matchTime;
    }

    public Object getHomePenalties() {
        return homePenalties;
    }

    public void setHomePenalties(Object homePenalties) {
        this.homePenalties = homePenalties;
    }

    public Object getAwayPenalties() {
        return awayPenalties;
    }

    public void setAwayPenalties(Object awayPenalties) {
        this.awayPenalties = awayPenalties;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
