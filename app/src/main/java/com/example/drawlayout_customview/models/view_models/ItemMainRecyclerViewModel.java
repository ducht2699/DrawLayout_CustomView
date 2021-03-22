package com.example.drawlayout_customview.models.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.models.response.CategoryResponse;
import com.example.drawlayout_customview.models.response.HOTWordResponse;
import com.example.drawlayout_customview.models.response.LoadMoreProductResponse;
import com.example.drawlayout_customview.models.response.ProductsResponse;
import com.example.drawlayout_customview.repositories.ItemMainRecyclerViewRepository;

public class ItemMainRecyclerViewModel extends ViewModel {
    private ItemMainRecyclerViewRepository itemRepo;

    public ItemMainRecyclerViewModel() {
        this.itemRepo = new ItemMainRecyclerViewRepository();
    }

    public LiveData<BannerResponse> getBanner(String token) {
        return itemRepo.getBanner(token);
    }

    public LiveData<ProductsResponse> getProducts(String token) {
        return itemRepo.getProducts(token);
    }

    public LiveData<CategoryResponse> getCategory() {
        return itemRepo.getCategory();
    }

    public LiveData<HOTWordResponse> getHotWord() {
        return itemRepo.getHotWord();
    }

    public LiveData<LoadMoreProductResponse> getLoadMoreProduct(String token, int page) {
        return  itemRepo.getLoadMoreProducts(token, page);
    }

}
