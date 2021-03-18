package com.example.drawlayout_customview.models.Item_main_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryItem {
    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("sort")
    private int sort;
    @Expose
    @SerializedName("imageUrl")
    private String imageUrl;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("editedTime")
    private String editedTime;
    @Expose
    @SerializedName("createdTime")
    private String createdTime;
    @Expose
    @SerializedName("delYn")
    private String delYn;

    public int getStatus() {
        return status;
    }

    public int getSort() {
        return sort;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
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
