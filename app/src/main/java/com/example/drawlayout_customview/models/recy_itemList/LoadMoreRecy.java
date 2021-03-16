package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.others.LoadMoreItem;

import java.util.List;

public class LoadMoreRecy {
    List<LoadMoreItem> loadMoreItems;

    public LoadMoreRecy(List<LoadMoreItem> loadMoreItems) {
        this.loadMoreItems = loadMoreItems;
    }

    public List<LoadMoreItem> getLoadMoreItems() {
        return loadMoreItems;
    }

    public void setLoadMoreItems(List<LoadMoreItem> loadMoreItems) {
        this.loadMoreItems = loadMoreItems;
    }
}
