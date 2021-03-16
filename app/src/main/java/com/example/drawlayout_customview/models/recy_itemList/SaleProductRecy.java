package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.product.SaleProduct;

import java.util.List;

public class SaleProductRecy {
    List<SaleProduct> list;

    public SaleProductRecy(List<SaleProduct> list) {
        this.list = list;
    }

    public List<SaleProduct> getList() {
        return list;
    }

    public void setList(List<SaleProduct> list) {
        this.list = list;
    }
}
