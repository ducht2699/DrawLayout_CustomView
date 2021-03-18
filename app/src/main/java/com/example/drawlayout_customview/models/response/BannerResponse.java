package com.example.drawlayout_customview.models.response;

import com.example.drawlayout_customview.models.Item_main_view.BannerItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("body")
    private List<BannerItem> bannerItem;
    @Expose
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public List<BannerItem> getBannerItem() {
        return bannerItem;
    }

    public int getStatus() {
        return status;
    }


}
