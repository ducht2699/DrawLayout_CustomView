package com.example.drawlayout_customview.models.response;

import com.example.drawlayout_customview.models.Item_main_view.LoadMoreProductItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class LoadMoreProductResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("body")
    private List<LoadMoreProductItem> loadMoreProductItem;
    @Expose
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public List<LoadMoreProductItem> getLoadMoreProductItem() {
        return loadMoreProductItem;
    }

    public int getStatus() {
        return status;
    }
}
