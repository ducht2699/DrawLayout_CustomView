package com.example.drawlayout_customview.models.item_list.product;

import com.example.drawlayout_customview.models.item_list.BaseItem;

public abstract class BaseProduct extends BaseItem {
    protected int m_Image;

    public BaseProduct(int m_Image) {
        this.m_Image = m_Image;
    }

    public int getM_Image() {
        return m_Image;
    }

    public void setM_Image(int m_Image) {
        this.m_Image = m_Image;
    }
}
