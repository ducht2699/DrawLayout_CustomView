package com.example.drawlayout_customview.models.item_list.product;

public abstract class PricedProduct extends BaseProduct {
    protected double m_Price;

    public PricedProduct(int m_Image, double m_Price) {
        super(m_Image);
        this.m_Price = m_Price;
    }

    public double getM_Price() {
        return m_Price;
    }

    public void setM_Price(double m_Price) {
        this.m_Price = m_Price;
    }
}
