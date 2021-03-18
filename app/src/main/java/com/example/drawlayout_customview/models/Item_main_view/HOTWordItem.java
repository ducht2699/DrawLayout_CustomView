package com.example.drawlayout_customview.models.Item_main_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HOTWordItem {
    @Expose
    @SerializedName("numberSearch")
    private int numberSearch;
    @Expose
    @SerializedName("wordType")
    private int wordType;
    @Expose
    @SerializedName("name")
    private String name;
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

    public int getNumberSearch() {
        return numberSearch;
    }

    public int getWordType() {
        return wordType;
    }

    public String getName() {
        return name;
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
