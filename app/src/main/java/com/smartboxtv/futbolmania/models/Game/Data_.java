
package com.smartboxtv.futbolmania.models.Game;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
