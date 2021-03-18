package com.example.drawlayout_customview.models.Item_main_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoadMoreProductItem {
    @Expose
    @SerializedName("brandName")
    private String brandName;
    @Expose
    @SerializedName("regionType")
    private int regionType;
    @Expose
    @SerializedName("endHotTime")
    private String endHotTime;
    @Expose
    @SerializedName("publishHotTime")
    private String publishHotTime;
    @Expose
    @SerializedName("distributorName")
    private String distributorName;
    @Expose
    @SerializedName("viewCount")
    private int viewCount;
    @Expose
    @SerializedName("virtualSellCount")
    private int virtualSellCount;
    @Expose
    @SerializedName("numberSell")
    private int numberSell;
    @Expose
    @SerializedName("hot")
    private boolean hot;
    @Expose
    @SerializedName("positionType")
    private int positionType;
    @Expose
    @SerializedName("discountPercent")
    private double discountPercent;
    @Expose
    @SerializedName("sharingNumber")
    private int sharingNumber;
    @Expose
    @SerializedName("commentNumber")
    private int commentNumber;
    @Expose
    @SerializedName("ownerId")
    private int ownerId;
    @Expose
    @SerializedName("images")
    private List<String> images;
    @Expose
    @SerializedName("categoryNm")
    private String categoryNm;
    @Expose
    @SerializedName("type")
    private int type;
    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("currencyId")
    private int currencyId;
    @Expose
    @SerializedName("specialPriceJp")
    private int specialPriceJp;
    @Expose
    @SerializedName("basePriceJp")
    private int basePriceJp;
    @Expose
    @SerializedName("finalPriceJp")
    private int finalPriceJp;
    @Expose
    @SerializedName("finalPrice")
    private int finalPrice;
    @Expose
    @SerializedName("specialPrice")
    private int specialPrice;
    @Expose
    @SerializedName("basePrice")
    private int basePrice;
    @Expose
    @SerializedName("categoryId")
    private int categoryId;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("uniqueId")
    private int uniqueId;
    @Expose
    @SerializedName("createdTime")
    private String createdTime;
    @Expose
    @SerializedName("delYn")
    private String delYn;

    public String getBrandName() {
        return brandName;
    }

    public int getRegionType() {
        return regionType;
    }

    public String getEndHotTime() {
        return endHotTime;
    }

    public String getPublishHotTime() {
        return publishHotTime;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getVirtualSellCount() {
        return virtualSellCount;
    }

    public int getNumberSell() {
        return numberSell;
    }

    public boolean isHot() {
        return hot;
    }

    public int getPositionType() {
        return positionType;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public int getSharingNumber() {
        return sharingNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public List<String> getImages() {
        return images;
    }

    public String getCategoryNm() {
        return categoryNm;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public int getSpecialPriceJp() {
        return specialPriceJp;
    }

    public int getBasePriceJp() {
        return basePriceJp;
    }

    public int getFinalPriceJp() {
        return finalPriceJp;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getDelYn() {
        return delYn;
    }
}
