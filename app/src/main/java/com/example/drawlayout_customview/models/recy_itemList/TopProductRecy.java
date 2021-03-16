package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.product.TopSoldProduct;

import java.util.List;

public class TopProductRecy {
    List<TopSoldProduct> list;

    public TopProductRecy(List<TopSoldProduct> list) {
        this.list = list;
    }

    public List<TopSoldProduct> getList() {
        return list;
    }

    public void setList(List<TopSoldProduct> list) {
        this.list = list;
    }
}
