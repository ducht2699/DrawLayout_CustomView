package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.product.RegionProduct;

import java.util.List;

public class RegionProductRecy {
    List<RegionProduct> list;

    public RegionProductRecy(List<RegionProduct> list) {
        this.list = list;
    }

    public List<RegionProduct> getList() {
        return list;
    }

    public void setList(List<RegionProduct> list) {
        this.list = list;
    }
}
