package com.example.drawlayout_customview.models.item_list.others;

import com.example.drawlayout_customview.models.item_list.BaseItem;

public class HotWordItem extends BaseItem {
    private String m_Word;

    public HotWordItem(String m_Word) {
        this.m_Word = m_Word;
    }

    public String getM_Word() {
        return m_Word;
    }

    public void setM_Word(String m_Word) {
        this.m_Word = m_Word;
    }
}
