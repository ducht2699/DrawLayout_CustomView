package com.example.drawlayout_customview.models.recy_itemList;

import com.example.drawlayout_customview.models.item_list.others.CategoryItem;

import java.util.List;

public class CategoryRecy {
    List<CategoryItem> categoryItems;

    public CategoryRecy(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }

    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }
}
