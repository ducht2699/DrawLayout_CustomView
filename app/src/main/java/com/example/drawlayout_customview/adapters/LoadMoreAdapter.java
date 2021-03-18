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

import java.util.List;

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

    private String standardizedMoney(String amount) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = amount.length() - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                sb.append(".");
                count = 0;
            }
            sb.append(amount.charAt(i));
            count++;
        }
        sb.reverse();
        return sb.toString();
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

        }
    }
}
