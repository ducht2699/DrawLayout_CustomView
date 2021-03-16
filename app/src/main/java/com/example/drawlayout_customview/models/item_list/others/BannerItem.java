package com.example.drawlayout_customview.models.item_list.others;

import androidx.annotation.NonNull;

import com.denzcoskun.imageslider.models.SlideModel;
import com.example.drawlayout_customview.Constants;
import com.example.drawlayout_customview.models.item_list.BaseItem;


import java.util.List;

public class BannerItem extends BaseItem {
    private int image;

    public BannerItem(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
