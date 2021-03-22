package com.example.drawlayout_customview.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.drawlayout_customview.adapters.ProductTypeAdapter;
import com.example.drawlayout_customview.databinding.ActivityMainBinding;
import com.example.drawlayout_customview.models.Item_main_view.HotProductItem;
import com.example.drawlayout_customview.models.Item_main_view.JapanProductItem;
import com.example.drawlayout_customview.models.Item_main_view.SaleProductItem;
import com.example.drawlayout_customview.models.Item_main_view.VietnameProductItem;
import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.models.response.CategoryResponse;
import com.example.drawlayout_customview.models.response.HOTWordResponse;
import com.example.drawlayout_customview.models.response.LoadMoreProductResponse;
import com.example.drawlayout_customview.models.view_models.ItemMainRecyclerViewModel;
import com.example.drawlayout_customview.R;
import com.example.drawlayout_customview.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ItemMainRecyclerViewModel itemViewModel;
    private ActivityMainBinding mBinding;
    private ProductTypeAdapter adapter;
    private List<Object> productTypeList;
    private int currentLoadMorePage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        itemViewModel = new ViewModelProvider(this).get(ItemMainRecyclerViewModel.class);
        initRecyclerViewContent();
        setRecyclerViewContent();

    }

    private void initRecyclerViewContent() {
        productTypeList = new ArrayList<>();
        productTypeList.add(new BannerResponse());
        productTypeList.add(new HotProductItem());
        productTypeList.add(new SaleProductItem());
        productTypeList.add(new JapanProductItem());
        productTypeList.add(new VietnameProductItem());
        productTypeList.add(new CategoryResponse());
        productTypeList.add(new HOTWordResponse());
        productTypeList.add(new LoadMoreProductResponse());
        adapter = new ProductTypeAdapter(productTypeList, this);
        mBinding.rcvProductTypeList.setAdapter(adapter);
        mBinding.rcvProductTypeList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mBinding.rcvProductTypeList.setItemViewCacheSize(20);
        if (!mBinding.rcvProductTypeList.canScrollVertically(1)) {
            Log.d("TAG", "Ended");
        }
    }

    private void setRecyclerViewContent() {
        getBanner();
        getProducts();
        getCategory();
        getHotWord();
        getLoadMore();
    }

    private void getLoadMore() {
        itemViewModel.getLoadMoreProduct(Constants.USER_TOKEN, currentLoadMorePage ).observe(this, loadMoreProductResponse -> {
            productTypeList.set(7, loadMoreProductResponse);
            adapter.notifyItemChanged(7);
        });
    }

    private void getHotWord() {
        itemViewModel.getHotWord().observe(this, hotWordResponse -> {
            productTypeList.set(6, hotWordResponse);
            adapter.notifyItemChanged(6);
        });
    }

    private void getCategory() {
        itemViewModel.getCategory().observe(this, categoryResponse -> {
            productTypeList.set(5, categoryResponse);
            adapter.notifyItemChanged(5);
        });
    }

    private void getProducts() {
        itemViewModel.getProducts(Constants.USER_TOKEN).observe(this, productsResponse -> {
            HotProductItem hotProductItems = new HotProductItem();
            hotProductItems.setList(productsResponse.getBody().getHots());
            productTypeList.set(1, hotProductItems);
            adapter.notifyItemChanged(1);

            SaleProductItem saleProductItem = new SaleProductItem();
            saleProductItem.setList(productsResponse.getBody().getSales());
            productTypeList.set(2, saleProductItem);
            adapter.notifyItemChanged(2);

            JapanProductItem japanProductItem = new JapanProductItem();
            japanProductItem.setList(productsResponse.getBody().getJapan());
            productTypeList.set(3, japanProductItem);
            adapter.notifyItemChanged(3);

            VietnameProductItem vietnameProductItem = new VietnameProductItem();
            vietnameProductItem.setList(productsResponse.getBody().getVietnam());
            productTypeList.set(4, vietnameProductItem);
            adapter.notifyItemChanged(4);
        });
    }

    private void getBanner() {
        itemViewModel.getBanner(Constants.USER_TOKEN).observe(this, bannerResponse -> {
            productTypeList.set(0, bannerResponse);
            adapter.notifyItemChanged(0);
        });
    }
}