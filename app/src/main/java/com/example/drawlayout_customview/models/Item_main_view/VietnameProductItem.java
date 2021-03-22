package com.example.drawlayout_customview.models.Item_main_view;

import com.example.drawlayout_customview.models.response.ProductsResponse;

import java.util.List;

public class VietnameProductItem {
    private List<ProductsResponse.Vietnam> list;

    public List<ProductsResponse.Vietnam> getList() {
        return list;
    }

    public void setList(List<ProductsResponse.Vietnam> list) {
        this.list = list;
    }
}
