package com.example.drawlayout_customview.models.response;

import com.example.drawlayout_customview.models.Item_main_view.HOTWordItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HOTWordResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("body")
    private List<HOTWordItem> HOTWordItem;
    @Expose
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public List<com.example.drawlayout_customview.models.Item_main_view.HOTWordItem> getHOTWordItem() {
        return HOTWordItem;
    }

    public int getStatus() {
        return status;
    }


}
