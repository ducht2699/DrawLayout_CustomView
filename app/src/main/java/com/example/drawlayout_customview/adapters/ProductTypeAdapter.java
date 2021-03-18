package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.drawlayout_customview.Constants;
import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.custom_view.ProductView;


import java.util.List;

import static com.example.drawlayout_customview.databinding.BannerItemBinding.inflate;

public class ProductTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> itemRecyclerViewMain;
    Context context;

    public ProductTypeAdapter(List<Object> itemRecyclerViewMain, Context context) {
        this.itemRecyclerViewMain = itemRecyclerViewMain;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constants.BANNER_VIEW_MODEL:
                return new BannerViewModel(LayoutInflater.from(context).inflate(R.layout.top_product_item, parent, false));
            case Constants.TOP_SOLD_VIEW_MODEL:
                return new HotProductViewModel(LayoutInflater.from(context).inflate(R.layout.top_product_item, parent, false));
            case Constants.SALE_VIEW_MODEL:
            case Constants.VIEWED_VIEW_MODEL:
            case Constants.JAPANESE_VIEW_MODEL:
            case Constants.VIETNAMESE_VIEW_MODEL:
                return new ProductsViewModel(LayoutInflater.from(context).inflate(R.layout.region_product_item, parent, false));
            case Constants.CATEGORY_VIEW_MODEL:
            case Constants.HOT_WORD_VIEW_MODEL:
                return new CategoryHOTViewModel(LayoutInflater.from(context).inflate(R.layout.hotkey_category_item, parent, false));
            case Constants.LOAD_MORE_VIEW_MODEL:
                return new LoadMoreViewModel(LayoutInflater.from(context).inflate(R.layout.load_more_list, parent, false));
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getItemCount() {
        return itemRecyclerViewMain.size();
    }

    public class BannerViewModel extends RecyclerView.ViewHolder {
        ImageSlider imageSlider;

        public BannerViewModel(@NonNull View itemView) {
            super(itemView);
            this.imageSlider = itemView.findViewById(R.id.ims_banner);
        }
    }

    public class CategoryHOTViewModel extends RecyclerView.ViewHolder {
        private RecyclerView rcv;
        private TextView tvTitle;

        public CategoryHOTViewModel(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_category_hot_keys);
            tvTitle = itemView.findViewById(R.id.tv_title_category);

        }


    }

    public class LoadMoreViewModel extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public LoadMoreViewModel(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_load_more_list);
        }


    }

    public class ProductsViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;

        public ProductsViewModel(@NonNull View itemView) {
            super(itemView);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_products);
            tvTitle = itemView.findViewById(R.id.tv_products_title);
            prv1 = itemView.findViewById(R.id.prv_product_1);
            prv2 = itemView.findViewById(R.id.prv_product_2);
            prv3 = itemView.findViewById(R.id.prv_product_3);
            prv4 = itemView.findViewById(R.id.prv_product_4);
        }

    }


    public class HotProductViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;
        private ProductView prv5;

        public HotProductViewModel(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_top_sold);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_top_sold);
            prv1 = itemView.findViewById(R.id.prv_top_sold_1);
            prv2 = itemView.findViewById(R.id.prv_top_sold_2);
            prv3 = itemView.findViewById(R.id.prv_top_sold_3);
            prv4 = itemView.findViewById(R.id.prv_top_sold_4);
            prv5 = itemView.findViewById(R.id.prv_top_sold_5);
        }

    }


}
