package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.models.Item_main_view.CategoryItem;
import com.example.drawlayout_customview.utils.Utils;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private final List<CategoryItem> categoryItems;
    private final Context context;

    public CategoryAdapter(List<CategoryItem> categoryItems, Context context) {
        this.categoryItems = categoryItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryItem categoryItem = categoryItems.get(position);
        holder.setData(categoryItem);
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView m_imvIcon;
        private final TextView m_tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m_imvIcon = itemView.findViewById(R.id.imv_category_icon);
            m_tvName = itemView.findViewById(R.id.tv_category_name);
        }

        public void setData(CategoryItem categoryItem) {
            Utils.setImageURL(context, m_imvIcon, categoryItem.getImageUrl());
            m_tvName.setText(categoryItem.getTitle());
        }
    }
}
