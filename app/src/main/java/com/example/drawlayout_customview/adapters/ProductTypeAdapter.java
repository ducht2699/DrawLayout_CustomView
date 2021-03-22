package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.drawlayout_customview.models.Item_main_view.BannerItem;
import com.example.drawlayout_customview.models.Item_main_view.HOTWordItem;
import com.example.drawlayout_customview.models.Item_main_view.HotProductItem;
import com.example.drawlayout_customview.models.Item_main_view.JapanProductItem;
import com.example.drawlayout_customview.models.Item_main_view.LoadMoreProductItem;
import com.example.drawlayout_customview.models.Item_main_view.SaleProductItem;
import com.example.drawlayout_customview.models.Item_main_view.VietnameProductItem;
import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.models.response.CategoryResponse;
import com.example.drawlayout_customview.models.response.HOTWordResponse;
import com.example.drawlayout_customview.models.response.LoadMoreProductResponse;
import com.example.drawlayout_customview.models.view_models.ItemMainRecyclerViewModel;
import com.example.drawlayout_customview.network.ApiProduct;
import com.example.drawlayout_customview.network.ApiService;
import com.example.drawlayout_customview.utils.Constants;
import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.custom_view.ProductView;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.drawlayout_customview.databinding.BannerItemBinding.inflate;

public class ProductTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> itemRecyclerViewMain;
    Context context;
    int currentPage = 0;
    int totalPages = 0;

    public ProductTypeAdapter(List<Object> itemRecyclerViewMain, Context context) {
        this.itemRecyclerViewMain = itemRecyclerViewMain;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constants.BANNER_VIEW_MODEL:
                return new BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false));
            case Constants.TOP_SOLD_VIEW_MODEL:
                return new HotProductViewHolder(LayoutInflater.from(context).inflate(R.layout.top_product_item, parent, false));
            case Constants.SALE_VIEW_MODEL:
            case Constants.VIEWED_VIEW_MODEL:
            case Constants.JAPANESE_VIEW_MODEL:
            case Constants.VIETNAMESE_VIEW_MODEL:
                return new ProductsViewHolder(LayoutInflater.from(context).inflate(R.layout.region_product_item, parent, false));
            case Constants.CATEGORY_VIEW_MODEL:
            case Constants.HOT_WORD_VIEW_MODEL:
                return new CategoryHOTViewHolder(LayoutInflater.from(context).inflate(R.layout.hotkey_category_item, parent, false));
            case Constants.LOAD_MORE_VIEW_MODEL:
                return new LoadMoreViewHolder(LayoutInflater.from(context).inflate(R.layout.load_more_list, parent, false));
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object object = itemRecyclerViewMain.get(position);
        if (object instanceof BannerResponse) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            BannerResponse bannerResponse = (BannerResponse) object;
            bannerViewHolder.setData(bannerResponse);
        } else if (object instanceof HotProductItem) {
            HotProductViewHolder hotProductViewHolder = (HotProductViewHolder) holder;
            HotProductItem hots = (HotProductItem) object;
            hotProductViewHolder.setHotProduct(hots);
        } else if (object instanceof SaleProductItem) {
            ProductsViewHolder productsViewHolder = (ProductsViewHolder) holder;
            SaleProductItem saleProductItem = (SaleProductItem) object;
            productsViewHolder.setDataSale(saleProductItem);
        } else if (object instanceof JapanProductItem) {
            ProductsViewHolder productsViewHolder = (ProductsViewHolder) holder;
            JapanProductItem saleProductItem = (JapanProductItem) object;
            productsViewHolder.setDataJapanese(saleProductItem);
        } else if (object instanceof VietnameProductItem) {
            ProductsViewHolder productsViewHolder = (ProductsViewHolder) holder;
            VietnameProductItem saleProductItem = (VietnameProductItem) object;
            productsViewHolder.setDataVietnam(saleProductItem);
        } else if (object instanceof CategoryResponse) {
            CategoryHOTViewHolder productsViewHolder = (CategoryHOTViewHolder) holder;
            CategoryResponse saleProductItem = (CategoryResponse) object;
            productsViewHolder.setData(saleProductItem);
        } else if (object instanceof HOTWordResponse) {
            CategoryHOTViewHolder categoryHOTViewHolder = (CategoryHOTViewHolder) holder;
            HOTWordResponse hotWordResponse = (HOTWordResponse) object;
            categoryHOTViewHolder.setHotWord(hotWordResponse);
        } else if (object instanceof LoadMoreProductResponse) {
            LoadMoreViewHolder loadMoreViewHolder = (LoadMoreViewHolder) holder;
            LoadMoreProductResponse loadMoreProductResponse = (LoadMoreProductResponse) object;
            loadMoreViewHolder.setData(loadMoreProductResponse);
        }
        else throw new IllegalArgumentException();
    }


    @Override
    public int getItemViewType(int position) {
        Object object = itemRecyclerViewMain.get(position);
        if (object instanceof BannerResponse) position = Constants.BANNER_VIEW_MODEL;
        else if (object instanceof HotProductItem) position = Constants.TOP_SOLD_VIEW_MODEL;
        else if (object instanceof SaleProductItem) position = Constants.SALE_VIEW_MODEL;
        else if (object instanceof JapanProductItem) position = Constants.JAPANESE_VIEW_MODEL;
        else if (object instanceof VietnameProductItem) position = Constants.VIETNAMESE_VIEW_MODEL;
        else if (object instanceof CategoryResponse) position = Constants.CATEGORY_VIEW_MODEL;
        else if (object instanceof HOTWordResponse) position = Constants.HOT_WORD_VIEW_MODEL;
        else if (object instanceof LoadMoreProductResponse)
            position = Constants.LOAD_MORE_VIEW_MODEL;
        return position;
    }

    @Override
    public int getItemCount() {
        return itemRecyclerViewMain.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageSlider imageSlider;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageSlider = itemView.findViewById(R.id.ims_banner);
            imageSlider.startSliding(3000);
        }

        public void setData(BannerResponse bannerResponse) {
            if (bannerResponse.getBannerItem() == null) return;
            List<SlideModel> slideModels = new ArrayList<>();
            for (BannerItem x : bannerResponse.getBannerItem()) {
                slideModels.add(new SlideModel(x.getImageUrl()));
            }
            imageSlider.setImageList(slideModels, true);
        }
    }

    public class CategoryHOTViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView rcv;
        private final TextView tvTitle;

        public CategoryHOTViewHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_category_hot_keys);
            tvTitle = itemView.findViewById(R.id.tv_title_category);

        }


        public void setData(CategoryResponse categoryResponse) {
            if (categoryResponse.getCategoryItem() == null) return;
            rcv.setAdapter(new CategoryAdapter(categoryResponse.getCategoryItem(), context));
            rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            tvTitle.setText("Danh mục");
        }

        public void setHotWord(HOTWordResponse hotWordResponse) {
            if (hotWordResponse.getHOTWordItem() == null) return;
            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
            layoutManager.setFlexWrap(FlexWrap.WRAP);
            rcv.setLayoutManager(layoutManager);
            List<String> list = new ArrayList<>();
            for (HOTWordItem x : hotWordResponse.getHOTWordItem()) {
                list.add(x.getName());
            }
            rcv.setAdapter(new KeyWordAdapter(list, context));
        }
    }

    public class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        private List<LoadMoreProductItem> list = new ArrayList<>();
        private LoadMoreAdapter adapter;

        public LoadMoreViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_load_more_list);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        }


        public void setData(LoadMoreProductResponse loadMoreProductResponse) {
            if (loadMoreProductResponse.getLoadMoreProductItem() == null) return;
            list.addAll(loadMoreProductResponse.getLoadMoreProductItem());
            adapter = new LoadMoreAdapter(list, context);
            recyclerView.setAdapter(adapter);
        }
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvViewAll;
        private final TextView tvTitle;
        private final ProductView prv1;
        private final ProductView prv2;
        private final ProductView prv3;
        private final ProductView prv4;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_products);
            tvTitle = itemView.findViewById(R.id.tv_products_title);
            prv1 = itemView.findViewById(R.id.prv_product_1);
            prv2 = itemView.findViewById(R.id.prv_product_2);
            prv3 = itemView.findViewById(R.id.prv_product_3);
            prv4 = itemView.findViewById(R.id.prv_product_4);
        }

        public void setDataSale(SaleProductItem saleProductItem) {
            if (saleProductItem.getList() == null) return;
            tvTitle.setText("Sản phẩm giảm giá");
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_sale_tag, 0);
            prv1.setData(context, saleProductItem.getList().get(0));
            prv2.setData(context, saleProductItem.getList().get(1));
            prv3.setData(context, saleProductItem.getList().get(2));
            prv4.setData(context, saleProductItem.getList().get(3));
        }

        public void setDataJapanese(JapanProductItem japanese) {
            if (japanese.getList() == null) return;
            tvTitle.setText("Bán tại Nhật");
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_japan_flag, 0);
            prv1.setData(context, japanese.getList().get(0));
            prv2.setData(context, japanese.getList().get(1));
            prv3.setData(context, japanese.getList().get(2));
            prv4.setData(context, japanese.getList().get(3));
        }

        public void setDataVietnam(VietnameProductItem vietnam) {
            if (vietnam.getList() == null) return;
            tvTitle.setText("Bán tại Việt Nam");
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_vietnam_flag, 0);
            prv1.setData(context, vietnam.getList().get(0));
            prv2.setData(context, vietnam.getList().get(1));
            prv3.setData(context, vietnam.getList().get(2));
            prv4.setData(context, vietnam.getList().get(3));
        }
    }


    public class HotProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvViewAll;
        private final TextView tvTitle;
        private final ProductView prv1;
        private final ProductView prv2;
        private final ProductView prv3;
        private final ProductView prv4;
        private final ProductView prv5;

        public HotProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_top_sold);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_top_sold);
            prv1 = itemView.findViewById(R.id.prv_top_sold_1);
            prv2 = itemView.findViewById(R.id.prv_top_sold_2);
            prv3 = itemView.findViewById(R.id.prv_top_sold_3);
            prv4 = itemView.findViewById(R.id.prv_top_sold_4);
            prv5 = itemView.findViewById(R.id.prv_top_sold_5);
        }

        public void setHotProduct(HotProductItem hots) {
            if (hots.getList() == null) return;
            tvTitle.setText("Sản phẩm bán chạy");
            prv1.setData(context, hots.getList().get(0));
            prv2.setData(context, hots.getList().get(1));
            prv3.setData(context, hots.getList().get(2));
            prv4.setData(context, hots.getList().get(3));
            prv5.setData(context, hots.getList().get(4));
        }
    }


}
