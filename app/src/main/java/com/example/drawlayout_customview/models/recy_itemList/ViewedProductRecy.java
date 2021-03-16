package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.product.ViewedProduct;

import java.util.List;

public class ViewedProductRecy {
    List<ViewedProduct> list;

    public ViewedProductRecy(List<ViewedProduct> list) {
        this.list = list;
    }

    public List<ViewedProduct> getList() {
        return list;
    }

    public void setList(List<ViewedProduct> list) {
        this.list = list;
    }
}
