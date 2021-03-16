package com.example.drawlayout_customview.models.item_list.product;

public class SaleProduct extends PricedProduct {
    protected float m_SalePercent;

    public SaleProduct(int m_Image, double m_Price, float m_SalePercent) {
        super(m_Image, m_Price);
        this.m_SalePercent = m_SalePercent;
    }

    public float getM_SalePercent() {
        return m_SalePercent;
    }

    public void setM_SalePercent(float m_SalePercent) {
        this.m_SalePercent = m_SalePercent;
    }
}
