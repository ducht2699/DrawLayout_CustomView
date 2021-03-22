package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.models.Item_main_view.LoadMoreProductItem;
import com.example.drawlayout_customview.utils.Utils;

import java.util.List;

import okhttp3.internal.Util;

public class LoadMoreAdapter extends RecyclerView.Adapter<LoadMoreAdapter.ViewHolder> {
    private final List<LoadMoreProductItem> LoadMoreProductItems;
    private final Context context;

    public LoadMoreAdapter(List<LoadMoreProductItem> LoadMoreProductItems, Context context) {
        this.LoadMoreProductItems = LoadMoreProductItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.load_more_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LoadMoreProductItem item = LoadMoreProductItems.get(position);
        holder.setData(item);
    }



    @Override
    public int getItemCount() {
        return LoadMoreProductItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView m_imvIcon;
        private final ImageView m_imvTagBackground;
        private final TextView m_tvSalePercent;
        private final TextView m_tvProductName;
        private final TextView m_tvOldPrice;
        private final TextView m_tvSalePrice;
        private final TextView m_tvSoldCount;
        private final TextView m_tvLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m_imvIcon = itemView.findViewById(R.id.imv_product_icon);
            m_tvSalePercent = itemView.findViewById(R.id.tv_sale_percent);
            m_tvProductName = itemView.findViewById(R.id.tv_product_name);
            m_tvSalePrice = itemView.findViewById(R.id.tv_price);
            m_tvOldPrice = itemView.findViewById(R.id.tv_old_price);
            m_tvSoldCount = itemView.findViewById(R.id.tv_product_sold);
            m_tvLocation = itemView.findViewById(R.id.tv_location);
            m_imvTagBackground = itemView.findViewById(R.id.imv_tag_background);
        }

        public void setData(LoadMoreProductItem item) {
            Utils.setImageURL(context, m_imvIcon, item.getImages().get(0));
            m_tvProductName.setText(item.getName());
            m_tvSoldCount.setText("Đã bán " + String.valueOf(item.getViewCount()));
            if (item.getDiscountPercent() == 0) {
                m_imvTagBackground.setVisibility(View.GONE);
                m_tvSalePercent.setVisibility(View.GONE);
                m_tvOldPrice.setVisibility(View.GONE);
                m_tvSalePrice.setText(Utils.standardizedMoney(String.valueOf((long)item.getBasePrice())));
            } else {
                m_tvSalePercent.setText("-" + (int)item.getDiscountPercent() + "%");
                m_tvOldPrice.setText(Utils.standardizedMoney(String.valueOf((long)item.getBasePrice())));
                Utils.setStrikeTextView(m_tvOldPrice);
                m_tvSalePrice.setText(Utils.standardizedMoney(String.valueOf((long)item.getFinalPrice())));
            }
        }
    }
}
