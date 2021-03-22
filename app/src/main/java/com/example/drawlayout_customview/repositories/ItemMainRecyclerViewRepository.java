package com.example.drawlayout_customview.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.models.response.CategoryResponse;
import com.example.drawlayout_customview.models.response.HOTWordResponse;
import com.example.drawlayout_customview.models.response.LoadMoreProductResponse;
import com.example.drawlayout_customview.models.response.ProductsResponse;
import com.example.drawlayout_customview.network.ApiProduct;
import com.example.drawlayout_customview.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemMainRecyclerViewRepository {
    private ApiService apiService;

    public ItemMainRecyclerViewRepository() {
        this.apiService = ApiProduct.getRetrofit().create(ApiService.class);
    }

    public LiveData<BannerResponse> getBanner(String token) {
        MutableLiveData<BannerResponse> result = new MutableLiveData<>();
        apiService.getBanner(token).enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(@NonNull Call<BannerResponse> call,@NonNull Response<BannerResponse> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<BannerResponse> call,@NonNull Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

    public LiveData<ProductsResponse> getProducts(String token) {
        MutableLiveData<ProductsResponse> result = new MutableLiveData<>();
        apiService.getProducts(token).enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

    public LiveData<CategoryResponse> getCategory() {
        MutableLiveData<CategoryResponse> result = new MutableLiveData<>();
        apiService.getCategory().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

    public LiveData<HOTWordResponse> getHotWord() {
        MutableLiveData<HOTWordResponse> result = new MutableLiveData<>();
        apiService.getHOTWord().enqueue(new Callback<HOTWordResponse>() {
            @Override
            public void onResponse(Call<HOTWordResponse> call, Response<HOTWordResponse> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<HOTWordResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

    public LiveData<LoadMoreProductResponse> getLoadMoreProducts(String token, int page) {
        MutableLiveData<LoadMoreProductResponse> result = new MutableLiveData<>();
        apiService.getLoadMoreProduct(token, page).enqueue(new Callback<LoadMoreProductResponse>() {
            @Override
            public void onResponse(Call<LoadMoreProductResponse> call, Response<LoadMoreProductResponse> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoadMoreProductResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

}
