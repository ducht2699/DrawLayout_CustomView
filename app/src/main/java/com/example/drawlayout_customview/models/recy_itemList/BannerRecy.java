package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.others.BannerItem;

import java.util.List;

public class BannerRecy {
    List<BannerItem> list;

    public BannerRecy(List<BannerItem> list) {
        this.list = list;
    }

    public List<BannerItem> getList() {
        return list;
    }

    public void setList(List<BannerItem> list) {
        this.list = list;
    }
}
