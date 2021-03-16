package com.example.drawlayout_customview.custom_view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.Utils;
import com.example.drawlayout_customview.models.item_list.BaseItem;
import com.example.drawlayout_customview.models.item_list.others.BannerItem;
import com.example.drawlayout_customview.models.item_list.others.CategoryItem;
import com.example.drawlayout_customview.models.item_list.others.HotWordItem;
import com.example.drawlayout_customview.models.item_list.product.BaseProduct;
import com.example.drawlayout_customview.models.item_list.product.RegionProduct;
import com.example.drawlayout_customview.models.item_list.product.SaleProduct;
import com.example.drawlayout_customview.models.item_list.product.TopSoldProduct;
import com.example.drawlayout_customview.models.item_list.product.ViewedProduct;


import java.util.List;

public class ProductView extends ConstraintLayout {
    ImageView imvProductImage;
    LinearLayout lnlSaleTag;
    TextView tvSalePercent, tvProductName, tvPrice, tvSold, tvOldPrice;

    public ProductView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public ProductView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ProductView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public ProductView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = inflate(context, R.layout.product_item, this);
        imvProductImage = view.findViewById(R.id.imv_product);
        lnlSaleTag = view.findViewById(R.id.ll_sale);
        tvSalePercent = view.findViewById(R.id.tv_discount_percent);
        tvProductName = view.findViewById(R.id.tv_name_product);
        tvPrice = view.findViewById(R.id.tv_price);
        tvSold = view.findViewById(R.id.tv_sold);
        tvOldPrice = view.findViewById(R.id.tv_old_price);
    }

    public void setProductContent(BaseProduct baseProduct) {
        if (baseProduct instanceof TopSoldProduct) {
            TopSoldProduct tsp = (TopSoldProduct) baseProduct;
            lnlSaleTag.setVisibility(GONE);
            tvProductName.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);

            imvProductImage.setBackgroundResource(tsp.getM_Image());
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)tsp.getM_Price())) + "¥");
            tvSold.setText("Đã bán " + tsp.getM_Sold());
        } else if (baseProduct instanceof SaleProduct) {
            SaleProduct sp = (SaleProduct) baseProduct;
            tvProductName.setVisibility(GONE);
            tvSold.setVisibility(GONE);

            imvProductImage.setBackgroundResource(sp.getM_Image());
            tvSalePercent.setText("-" + Utils.roundTo(sp.getM_SalePercent(), 1) + "%");
            tvOldPrice.setText(Utils.standardizedMoney(String.valueOf((long)sp.getM_Price())) + "¥");
            tvOldPrice.setPaintFlags(tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            double currentPrice = sp.getM_Price() - sp.getM_Price() * sp.getM_SalePercent() / 100.0f;
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)currentPrice)) + "¥");


        } else if (baseProduct instanceof ViewedProduct) {
            ViewedProduct vd = (ViewedProduct) baseProduct;
            lnlSaleTag.setVisibility(GONE);
            tvProductName.setVisibility(GONE);
            tvPrice.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);
            tvSold.setVisibility(GONE);

            imvProductImage.setBackgroundResource(vd.getM_Image());
        } else if (baseProduct instanceof RegionProduct) {
            lnlSaleTag.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);
            RegionProduct rg = (RegionProduct) (baseProduct);
            tvProductName.setText(rg.getM_Name());
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)rg.getM_Price())) + "¥");
            tvSold.setText("Đã bán " + String.valueOf(rg.getM_Sold()));
        }
        invalidate();
    }
}