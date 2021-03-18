package com.example.drawlayout_customview.models.Item_main_view;

import com.example.drawlayout_customview.models.response.ProductsResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductTotal {
    @Expose
    @SerializedName("vietnam")
    private List<Products> productVN;
    @Expose
    @SerializedName("japan")
    private List<Products> productJP;
    @Expose
    @SerializedName("sales")
    private List<Products> sales;
    @Expose
    @SerializedName("hots")
    private List<Products> hots;

    public List<Products> getProductVN() {
        return productVN;
    }

    public List<Products> getProductJP() {
        return productJP;
    }

    public List<Products> getSales() {
        return sales;
    }

    public List<Products> getHots() {
        return hots;
    }
}
