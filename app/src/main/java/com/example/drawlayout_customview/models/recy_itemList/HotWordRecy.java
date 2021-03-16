package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.others.HotWordItem;

import java.util.List;

public class HotWordRecy {
    List<HotWordItem> hotWordItems;

    public HotWordRecy(List<HotWordItem> hotWordItems) {
        this.hotWordItems = hotWordItems;
    }

    public List<HotWordItem> getHotWordItems() {
        return hotWordItems;
    }

    public void setHotWordItems(List<HotWordItem> hotWordItems) {
        this.hotWordItems = hotWordItems;
    }
}
