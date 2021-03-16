package com.example.drawlayout_customview.models.item_list.product;

public class RegionProduct extends BaseProduct {
    double m_Price;
    int m_Sold;
    protected String m_Name;
    protected String m_Location;

    public RegionProduct(int m_Image, double m_Price, int m_Sold, String m_Name, String m_Location) {
        super(m_Image);
        this.m_Price = m_Price;
        this.m_Sold = m_Sold;
        this.m_Name = m_Name;
        this.m_Location = m_Location;
    }

    public double getM_Price() {
        return m_Price;
    }

    public void setM_Price(double m_Price) {
        this.m_Price = m_Price;
    }

    public int getM_Sold() {
        return m_Sold;
    }

    public void setM_Sold(int m_Sold) {
        this.m_Sold = m_Sold;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getM_Location() {
        return m_Location;
    }

    public void setM_Location(String m_Location) {
        this.m_Location = m_Location;
    }
}
