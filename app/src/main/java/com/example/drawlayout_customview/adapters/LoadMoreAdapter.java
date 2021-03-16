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
import com.example.drawlayout_customview.models.item_list.others.LoadMoreItem;

import java.util.List;

public class LoadMoreAdapter extends RecyclerView.Adapter<LoadMoreAdapter.ViewHolder> {
    private List<LoadMoreItem> loadMoreItems;
    private Context context;

    public LoadMoreAdapter(List<LoadMoreItem> loadMoreItems, Context context) {
        this.loadMoreItems = loadMoreItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.load_more_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LoadMoreItem item = loadMoreItems.get(position);
        holder.m_imvIcon.setImageDrawable(context.getDrawable(item.getM_iIcon()));
        holder.m_tvProductName.setText(item.getM_sName());
        double price = item.getM_lPrice();
        if (item.isSale()) {
            holder.m_tvOldPrice.setText(standardizedMoney(String.valueOf((long) price)) + "¥");
            holder.m_tvOldPrice.setPaintFlags(holder.m_tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            price -= price * (item.getM_fSalePercent() / 100d);
            holder.m_tvSalePrice.setText(String.valueOf(price) + "¥");
            holder.m_tvSalePercent.setText("-" + String.valueOf((long) item.getM_fSalePercent()) + "%");

        } else {
            holder.m_imvTagBackground.setVisibility(View.GONE);
            holder.m_tvSalePercent.setVisibility(View.GONE);
            holder.m_tvOldPrice.setVisibility(View.GONE);
        }
        holder.m_tvSalePrice.setText(standardizedMoney(String.valueOf((long) price)) + "¥");
        holder.m_tvLocation.setText(item.getM_sLocation());
        holder.m_tvSoldCount.setText("Đã bán " + String.valueOf(item.getM_iSoldCount()));
    }

    private String standardizedMoney(String amount) {
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        for (int i = amount.length() - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                sb.append(".");
                count = 0;
            }
            sb.append(String.valueOf(amount.charAt(i)));
            count++;
        }
        sb.reverse();
        return sb.toString();
    }


    @Override
    public int getItemCount() {
        return loadMoreItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView m_imvIcon, m_imvTagBackground;
        private TextView m_tvSalePercent, m_tvProductName, m_tvOldPrice, m_tvSalePrice, m_tvSoldCount, m_tvLocation;

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
    }
}
