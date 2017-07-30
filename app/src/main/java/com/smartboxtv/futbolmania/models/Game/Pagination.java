
package com.smartboxtv.futbolmania.models.Game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("first")
    @Expose
    private Integer first;
    @SerializedName("items")
    @Expose
    private Integer items;
    @SerializedName("last")
    @Expose
    private Integer last;
    @SerializedName("next")
    @Expose
    private Integer next;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

}
