package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;

import com.denzcoskun.imageslider.models.SlideModel;
import com.example.drawlayout_customview.Constants;
import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.custom_view.ProductView;
import com.example.drawlayout_customview.models.item_list.others.BannerItem;
import com.example.drawlayout_customview.models.item_list.others.HotWordItem;
import com.example.drawlayout_customview.models.item_list.others.LoadMoreItem;
import com.example.drawlayout_customview.models.recy_itemList.BannerRecy;

import com.example.drawlayout_customview.models.recy_itemList.CategoryRecy;
import com.example.drawlayout_customview.models.recy_itemList.HotWordRecy;
import com.example.drawlayout_customview.models.recy_itemList.LoadMoreRecy;
import com.example.drawlayout_customview.models.recy_itemList.RegionProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.SaleProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.TopProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.ViewedProductRecy;
import com.google.android.flexbox.FlexboxLayoutManager;


import java.util.ArrayList;
import java.util.List;

public class ProductTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> baseItems;
    Context context;

    public ProductTypeAdapter(List<Object> baseItems, Context context) {
        this.baseItems = baseItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constants.BANNER_VIEW_MODEL:
                return new BannerViewModel(LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false));
            case Constants.TOP_SOLD_VIEW_MODEL:
                return new TopSoldProductViewModel(LayoutInflater.from(context).inflate(R.layout.top_product_item, parent, false));
            case Constants.SALE_VIEW_MODEL:
                return new SaleProductViewModel(LayoutInflater.from(context).inflate(R.layout.sale_product_item, parent, false));
            case Constants.VIEWED_VIEW_MODEL:
                return new ViewedProductViewModel(LayoutInflater.from(context).inflate(R.layout.viewed_product_item, parent, false));
            case Constants.JAPANESE_VIEW_MODEL:
            case Constants.VIETNAMESE_VIEW_MODEL:
                return new RegionProductViewModel(LayoutInflater.from(context).inflate(R.layout.region_product_item, parent, false));
            case Constants.CATEGORY_VIEW_MODEL:
            case Constants.HOT_WORD_VIEW_MODEL:
                return new CategoryHOTViewModel(LayoutInflater.from(context).inflate(R.layout.hotkey_category_item, parent, false));
            case Constants.LOAD_MORE_VIEW_MODEL:
                return new LoadMoreViewModel(LayoutInflater.from(context).inflate(R.layout.load_more_list, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object object = baseItems.get(position);
        if (object instanceof BannerRecy) {
            BannerViewModel bannerViewModel = (BannerViewModel) holder;
            BannerRecy bannerRecy = (BannerRecy) object;
            List<SlideModel> slideModels = new ArrayList<>();
            for (BannerItem x : bannerRecy.getList()) {
                slideModels.add(new SlideModel(x.getImage()));
            }
            bannerViewModel.m_ImageSlider.setImageList(slideModels, true);
            bannerViewModel.m_ImageSlider.stopSliding();
        } else if (object instanceof TopProductRecy) {
            TopSoldProductViewModel topSoldProductViewModel = (TopSoldProductViewModel) holder;
            TopProductRecy topProductRecy = (TopProductRecy) object;
            topSoldProductViewModel.setData(topProductRecy);
        } else if (object instanceof SaleProductRecy) {
            SaleProductViewModel saleProductViewModel = (SaleProductViewModel) holder;
            SaleProductRecy saleProductRecy = (SaleProductRecy) object;
            saleProductViewModel.setData(saleProductRecy);
        } else if (object instanceof ViewedProductRecy) {
            ViewedProductViewModel viewedProductViewModel = (ViewedProductViewModel) holder;
            ViewedProductRecy viewedProductRecy = (ViewedProductRecy) object;
            viewedProductViewModel.setData(viewedProductRecy);
        } else if (object instanceof RegionProductRecy) {
            RegionProductRecy regionProduct = (RegionProductRecy) object;
            RegionProductViewModel regionProductViewModel = (RegionProductViewModel) holder;
            regionProductViewModel.setData(regionProduct);
        } else if (object instanceof CategoryRecy) {
            CategoryHOTViewModel categoryHOTViewModel = (CategoryHOTViewModel) holder;
            CategoryRecy categoryRecy = (CategoryRecy) object;
            categoryHOTViewModel.setData(categoryRecy);

        } else if (object instanceof HotWordRecy) {
            CategoryHOTViewModel categoryHOTViewModel = (CategoryHOTViewModel) holder;
            HotWordRecy hotWordRecy = (HotWordRecy) object;
            categoryHOTViewModel.setDataHot(hotWordRecy);


        } else if (object instanceof LoadMoreRecy) {
            LoadMoreViewModel loadMoreViewModel = (LoadMoreViewModel) holder;
            LoadMoreRecy loadMoreRecy = (LoadMoreRecy) object;
            loadMoreViewModel.setData(loadMoreRecy);
        }
    }


    @Override
    public int getItemViewType(int position) {
        Object object = baseItems.get(position);
        if (object instanceof BannerRecy) {
            return Constants.BANNER_VIEW_MODEL;
        }
        if (object instanceof TopProductRecy) {
            return Constants.TOP_SOLD_VIEW_MODEL;
        }
        if (object instanceof SaleProductRecy) {
            return Constants.SALE_VIEW_MODEL;
        }
        if (object instanceof ViewedProductRecy) {
            return Constants.VIEWED_VIEW_MODEL;
        }
        if (object instanceof RegionProductRecy) {
            RegionProductRecy regionProduct = (RegionProductRecy) object;
            if (regionProduct.getList().get(0).getM_Location().equals("Viet Nam")) {
                return Constants.VIETNAMESE_VIEW_MODEL;
            } else return Constants.JAPANESE_VIEW_MODEL;
        }
        if (object instanceof CategoryRecy) {
            return Constants.CATEGORY_VIEW_MODEL;
        }
        if (object instanceof HotWordRecy) {
            return Constants.HOT_WORD_VIEW_MODEL;
        }
        if (object instanceof LoadMoreRecy) {
            return Constants.LOAD_MORE_VIEW_MODEL;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return baseItems.size();
    }


    public class BannerViewModel extends RecyclerView.ViewHolder {
        private ImageSlider m_ImageSlider;

        public BannerViewModel(@NonNull View itemView) {
            super(itemView);
            m_ImageSlider = itemView.findViewById(R.id.ims_banner);
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

        public void setData(CategoryRecy categoryRecy) {
            tvTitle.setText("Danh mục");
            LinearLayoutManager lnl = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            rcv.setLayoutManager(lnl);
            rcv.setAdapter(new CategoryAdapter(categoryRecy.getCategoryItems(), context));
        }

        public void setDataHot(HotWordRecy hotWordRecy) {
            tvTitle.setText("Từ khóa HOT");
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(context);
            rcv.setLayoutManager(flexboxLayoutManager);
            List<String> list = new ArrayList<>();
            for (HotWordItem x : hotWordRecy.getHotWordItems()) {
                list.add(x.getM_Word());
            }
            rcv.setAdapter(new KeyWordAdapter(list, context));
        }
    }

    public class LoadMoreViewModel extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public LoadMoreViewModel(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_load_more_list);
        }

        public void setData(LoadMoreRecy loadMoreRecy) {

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);

            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(new LoadMoreAdapter(loadMoreRecy.getLoadMoreItems(), context));
        }
    }

    public class RegionProductViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;

        public RegionProductViewModel(@NonNull View itemView) {
            super(itemView);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_product);
            tvTitle = itemView.findViewById(R.id.tv_title_japanese);
            prv1 = itemView.findViewById(R.id.prv_japanese_product_1);
            prv2 = itemView.findViewById(R.id.prv_japanese_product_2);
            prv3 = itemView.findViewById(R.id.prv_japanese_product_3);
            prv4 = itemView.findViewById(R.id.prv_japanese_product_4);
        }

        public void setData(RegionProductRecy regionProduct) {
            prv1.setProductContent(regionProduct.getList().get(0));
            prv2.setProductContent(regionProduct.getList().get(1));
            prv3.setProductContent(regionProduct.getList().get(2));
            prv4.setProductContent(regionProduct.getList().get(3));
            if (regionProduct.getList().get(0).getM_Location().equals("Viet Nam")) {
               tvTitle.setText("Hàng Việt");
               tvTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_vietnam_flag, 0);
            } else {
                tvTitle.setText("Hàng Nhật");
                tvTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_japan_flag, 0);
            }
        }
    }

    public class SaleProductViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;

        public SaleProductViewModel(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_sale_product);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_sale_product);
            prv1 = itemView.findViewById(R.id.prv_sale_product_1);
            prv2 = itemView.findViewById(R.id.prv_sale_product_2);
            prv3 = itemView.findViewById(R.id.prv_sale_product_3);
            prv4 = itemView.findViewById(R.id.prv_sale_product_4);
        }

        public void setData(SaleProductRecy saleProductRecy) {
            prv1.setProductContent(saleProductRecy.getList().get(0));
            prv2.setProductContent(saleProductRecy.getList().get(1));
            prv3.setProductContent(saleProductRecy.getList().get(2));
            prv4.setProductContent(saleProductRecy.getList().get(3));
        }
    }

    public class TopSoldProductViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;
        private ProductView prv5;

        public TopSoldProductViewModel(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_top_sold);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_top_sold);
            prv1 = itemView.findViewById(R.id.prv_top_sold_1);
            prv2 = itemView.findViewById(R.id.prv_top_sold_2);
            prv3 = itemView.findViewById(R.id.prv_top_sold_3);
            prv4 = itemView.findViewById(R.id.prv_top_sold_4);
            prv5 = itemView.findViewById(R.id.prv_top_sold_5);
        }

        public void setData(TopProductRecy topProductRecy) {
            prv1.setProductContent(topProductRecy.getList().get(0));
            prv2.setProductContent(topProductRecy.getList().get(1));
            prv3.setProductContent(topProductRecy.getList().get(2));
            prv4.setProductContent(topProductRecy.getList().get(3));
            prv5.setProductContent(topProductRecy.getList().get(4));
        }
    }

    public class ViewedProductViewModel extends RecyclerView.ViewHolder {
        private TextView tvViewAll, tvTitle;
        private ProductView prv1;
        private ProductView prv2;
        private ProductView prv3;
        private ProductView prv4;

        public ViewedProductViewModel(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_viewed_product);
            tvViewAll = itemView.findViewById(R.id.tv_view_all_viewed_product);
            prv1 = itemView.findViewById(R.id.prv_viewed_product_1);
            prv2 = itemView.findViewById(R.id.prv_viewed_product_2);
            prv3 = itemView.findViewById(R.id.prv_viewed_product_3);
            prv4 = itemView.findViewById(R.id.prv_viewed_product_4);
        }

        public void setData(ViewedProductRecy viewedProductRecy) {
            prv1.setProductContent(viewedProductRecy.getList().get(0));
            prv2.setProductContent(viewedProductRecy.getList().get(1));
            prv3.setProductContent(viewedProductRecy.getList().get(2));
            prv4.setProductContent(viewedProductRecy.getList().get(3));
        }
    }


}
