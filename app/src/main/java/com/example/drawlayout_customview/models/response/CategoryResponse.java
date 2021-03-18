package com.example.drawlayout_customview.models.response;

import com.example.drawlayout_customview.models.Item_main_view.CategoryItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class CategoryResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("body")
    private List<CategoryItem> categoryItem;
    @Expose
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public List<CategoryItem> getCategoryItem() {
        return categoryItem;
    }

    public int getStatus() {
        return status;
    }
}
