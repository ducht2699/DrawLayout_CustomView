package com.example.drawlayout_customview.models.item_list.others;


import com.example.drawlayout_customview.models.item_list.BaseItem;

public class LoadMoreItem extends BaseItem {
    private int m_iIcon;
    private double m_lPrice;
    private boolean isSale;
    private String m_sLocation;
    private int m_iSoldCount;
    private String m_sName;
    private float m_fSalePercent;

    public LoadMoreItem(int m_iIcon, double m_lPrice, boolean isSale, String m_sLocation, int m_iSoldCount, String m_sName, float m_fSalePercent) {
        this.m_iIcon = m_iIcon;
        this.m_lPrice = m_lPrice;
        this.isSale = isSale;
        this.m_sLocation = m_sLocation;
        this.m_iSoldCount = m_iSoldCount;
        this.m_sName = m_sName;
        this.m_fSalePercent = m_fSalePercent;
    }

    public LoadMoreItem(int m_iIcon, double m_lPrice, String m_sLocation, int m_iSoldCount, String m_sName) {
        this.m_iIcon = m_iIcon;
        this.m_lPrice = m_lPrice;
        this.isSale = false;
        this.m_sLocation = m_sLocation;
        this.m_iSoldCount = m_iSoldCount;
        this.m_sName = m_sName;
    }

    public int getM_iIcon() {
        return m_iIcon;
    }

    public void setM_iIcon(int m_iIcon) {
        this.m_iIcon = m_iIcon;
    }

    public double getM_lPrice() {
        return m_lPrice;
    }

    public void setM_lPrice(double m_lPrice) {
        this.m_lPrice = m_lPrice;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public String getM_sLocation() {
        return m_sLocation;
    }

    public void setM_sLocation(String m_sLocation) {
        this.m_sLocation = m_sLocation;
    }

    public int getM_iSoldCount() {
        return m_iSoldCount;
    }

    public void setM_iSoldCount(int m_iSoldCount) {
        this.m_iSoldCount = m_iSoldCount;
    }

    public String getM_sName() {
        return m_sName;
    }

    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

    public float getM_fSalePercent() {
        return m_fSalePercent;
    }

    public void setM_fSalePercent(float m_fSalePercent) {
        this.m_fSalePercent = m_fSalePercent;
    }
}
