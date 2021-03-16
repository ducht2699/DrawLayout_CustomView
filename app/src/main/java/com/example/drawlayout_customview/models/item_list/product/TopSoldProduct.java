package com.example.drawlayout_customview.models.item_list.product;

public class TopSoldProduct extends PricedProduct {
    protected int m_Sold;

    public TopSoldProduct(int m_Image, double m_Price, int m_Sold) {
        super(m_Image, m_Price);
        this.m_Sold = m_Sold;
    }

    public int getM_Sold() {
        return m_Sold;
    }

    public void setM_Sold(int m_Sold) {
        this.m_Sold = m_Sold;
    }
}
