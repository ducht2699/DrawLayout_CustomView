package com.example.drawlayout_customview.models.item_list.others;

import com.example.drawlayout_customview.models.item_list.BaseItem;

public class CategoryItem extends BaseItem {
    private int m_iIcon;
    private String m_sName;

    public CategoryItem(int m_iIcon, String m_sName) {
        this.m_iIcon = m_iIcon;
        this.m_sName = m_sName;
    }

    public int getM_iIcon() {
        return m_iIcon;
    }

    public void setM_iIcon(int m_iIcon) {
        this.m_iIcon = m_iIcon;
    }

    public String getM_sName() {
        return m_sName;
    }

    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

}
