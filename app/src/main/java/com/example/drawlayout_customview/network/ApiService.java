package com.example.drawlayout_customview.network;


import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.models.response.CategoryResponse;
import com.example.drawlayout_customview.models.response.HOTWordResponse;
import com.example.drawlayout_customview.models.response.LoadMoreProductResponse;
import com.example.drawlayout_customview.models.response.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/jappserver/s/v1/banner/get-product")
    Call<BannerResponse> getBanner(@Header("Authorization") String value);

    @GET("/jappserver/s/v1/product/get-product-hot")
    Call<ProductsResponse> getProducts(@Header("Authorization") String token);

    @GET("/jappserver/s/v1/product/get-category")
    Call<CategoryResponse> getCategory();

    @GET("/jappserver/s/v1/word/get-word-hot?wordType=PRODUCT")
    Call<HOTWordResponse> getHOTWord();

    @GET("/jappserver/s/v1/product/get-products")
    Call<LoadMoreProductResponse> getLoadMoreProduct(@Header("Authorization") String token, @Query("page") int page);
}
