package com.example.drawlayout_customview.models.Item_main_view;

import com.example.drawlayout_customview.models.response.ProductsResponse;
import com.example.drawlayout_customview.models.response.ProductsResponse.Sales;

import java.util.List;

public class SaleProductItem {
    private List<Sales> list;

    public List<Sales> getList() {
        return list;
    }

    public void setList(List<Sales> list) {
        this.list = list;
    }
}
