package com.example.drawlayout_customview.models.Item_main_view;

import com.example.drawlayout_customview.models.response.ProductsResponse;

import java.util.List;

public class HotProductItem {
    private List<ProductsResponse.Hots> list;

    public List<ProductsResponse.Hots> getList() {
        return list;
    }

    public void setList(List<ProductsResponse.Hots> list) {
        this.list = list;
    }
}
