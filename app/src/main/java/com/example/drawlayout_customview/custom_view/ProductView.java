package com.example.drawlayout_customview.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.models.response.ProductsResponse;
import com.example.drawlayout_customview.utils.Utils;

import static com.example.drawlayout_customview.models.response.ProductsResponse.*;

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


    public void setData(Context context, Object object) {
        if (object instanceof Hots) {
            tvProductName.setVisibility(GONE);
            lnlSaleTag.setVisibility(GONE);
            tvSalePercent.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);
            Hots hots = (Hots) object;
            Utils.setImageURL(context, imvProductImage, hots.getImages().get(0));
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)hots.getBasePrice())));
            tvSold.setText("Đã bán " + hots.getViewCount());
        } else if (object instanceof Sales) {
            tvProductName.setVisibility(GONE);
            tvSold.setVisibility(GONE);
            Sales sales = (Sales) object;
            Utils.setImageURL(context, imvProductImage, sales.getImages().get(0));
            tvSalePercent.setText("-" + (int)sales.getDiscountPercent() + "%");
            tvOldPrice.setText(Utils.standardizedMoney(String.valueOf((long)sales.getBasePrice())));
            Utils.setStrikeTextView(tvOldPrice);
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)sales.getFinalPrice())));
        } else if (object instanceof Japan) {
            lnlSaleTag.setVisibility(GONE);
            tvSalePercent.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);
            Japan japan = (Japan) object;
            Utils.setImageURL(context, imvProductImage, japan.getImages().get(0));
            tvProductName.setText(japan.getName());
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)japan.getBasePrice())));
            tvSold.setText("Đã bán " + japan.getViewCount());
        } else if (object instanceof Vietnam) {
            lnlSaleTag.setVisibility(GONE);
            tvSalePercent.setVisibility(GONE);
            tvOldPrice.setVisibility(GONE);
            Vietnam vietnam = (Vietnam) object;
            Utils.setImageURL(context, imvProductImage, vietnam.getImages().get(0));
            tvProductName.setText(vietnam.getName());
            tvPrice.setText(Utils.standardizedMoney(String.valueOf((long)vietnam.getBasePrice())));
            tvSold.setText("Đã bán " + vietnam.getViewCount());
        }
    }
}