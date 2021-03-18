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


}