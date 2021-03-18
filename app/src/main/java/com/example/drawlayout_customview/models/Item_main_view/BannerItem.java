package com.example.drawlayout_customview.models.Item_main_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class BannerItem {
    @Expose
    @SerializedName("objectId")
    private int objectId;
    @Expose
    @SerializedName("imageUrl")
    private String imageUrl;
    @Expose
    @SerializedName("screenType")
    private int screenType;
    @Expose
    @SerializedName("functionId")
    private int functionId;
    @Expose
    @SerializedName("content")
    private String content;
    @Expose
    @SerializedName("ownerId")
    private int ownerId;
    @Expose
    @SerializedName("uniqueId")
    private int uniqueId;
    @Expose
    @SerializedName("editedTime")
    private String editedTime;
    @Expose
    @SerializedName("createdTime")
    private String createdTime;
    @Expose
    @SerializedName("delYn")
    private String delYn;

    public int getObjectId() {
        return objectId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getScreenType() {
        return screenType;
    }

    public int getFunctionId() {
        return functionId;
    }

    public String getContent() {
        return content;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public String getEditedTime() {
        return editedTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getDelYn() {
        return delYn;
    }
}