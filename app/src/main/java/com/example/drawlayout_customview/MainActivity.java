package com.example.drawlayout_customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.drawlayout_customview.adapters.ProductTypeAdapter;

import com.example.drawlayout_customview.models.Item_main_view.BannerItem;
import com.example.drawlayout_customview.models.response.BannerResponse;
import com.example.drawlayout_customview.network.ApiProduct;
import com.example.drawlayout_customview.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Object> itemRecyclerViewMain = new ArrayList<>();
    RecyclerView rcvProductList;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiProduct.getRetrofit().create(ApiService.class);

        setContentRecyclerView();
        initRecyclerView();
    }

    private void setContentRecyclerView() {
        setBanner();

    }

    private void setBanner() {
        apiService.getBanner(Constants.HEADER_BANNER)
                .enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                BannerResponse bannerResponse = response.body();
                itemRecyclerViewMain.add(bannerResponse.getBannerItem());
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {

            }
        });
    }

    private void initRecyclerView() {
        rcvProductList = findViewById(R.id.rcv_product_type_list);
        ProductTypeAdapter adapter = new ProductTypeAdapter(itemRecyclerViewMain, this);
        rcvProductList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvProductList.setLayoutManager(linearLayoutManager);
        rcvProductList.setNestedScrollingEnabled(false);
        rcvProductList.setItemViewCacheSize(20);
    }

}