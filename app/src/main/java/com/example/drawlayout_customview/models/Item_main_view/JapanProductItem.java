package com.example.drawlayout_customview.models.Item_main_view;

import com.example.drawlayout_customview.models.response.ProductsResponse;

import java.util.List;

public class JapanProductItem {
    private List<ProductsResponse.Japan> list;

    public List<ProductsResponse.Japan> getList() {
        return list;
    }

    public void setList(List<ProductsResponse.Japan> list) {
        this.list = list;
    }
}
