package com.example.drawlayout_customview.models.response;

import com.example.drawlayout_customview.models.Item_main_view.ProductTotal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class ProductsResponse {


    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("body")
    private ProductTotal productTotal;
    @Expose
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public ProductTotal getProductTotal() {
        return productTotal;
    }

    public int getStatus() {
        return status;
    }
}