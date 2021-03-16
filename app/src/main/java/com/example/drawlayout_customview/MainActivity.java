package com.example.drawlayout_customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.drawlayout_customview.adapters.ProductTypeAdapter;
import com.example.drawlayout_customview.models.item_list.others.BannerItem;
import com.example.drawlayout_customview.models.item_list.others.CategoryItem;
import com.example.drawlayout_customview.models.item_list.others.HotWordItem;
import com.example.drawlayout_customview.models.item_list.others.LoadMoreItem;
import com.example.drawlayout_customview.models.item_list.product.RegionProduct;
import com.example.drawlayout_customview.models.item_list.product.SaleProduct;
import com.example.drawlayout_customview.models.item_list.product.TopSoldProduct;
import com.example.drawlayout_customview.models.item_list.product.ViewedProduct;
import com.example.drawlayout_customview.models.recy_itemList.BannerRecy;
import com.example.drawlayout_customview.models.recy_itemList.CategoryRecy;
import com.example.drawlayout_customview.models.recy_itemList.HotWordRecy;
import com.example.drawlayout_customview.models.recy_itemList.LoadMoreRecy;
import com.example.drawlayout_customview.models.recy_itemList.RegionProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.SaleProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.TopProductRecy;
import com.example.drawlayout_customview.models.recy_itemList.ViewedProductRecy;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Object> viewModels = new ArrayList<>();
    RecyclerView rcvProductList;
    int image = R.drawable.product_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentRecyclerView();
        initRecyclerView();
    }

    private void setContentRecyclerView() {
//        setBanner();
        setTopSoldProduct();
        setSaleProduct();
        setViewedProduct();
        setJapanese();
        setVietnamese();
        setCategory();
        setHot();
        setLoadMore();
    }

    private void setLoadMore() {
        List<LoadMoreItem> loadMoreItems = new ArrayList<>();
        loadMoreItems.add(new LoadMoreItem(image, 2959002d, "Việt Nam", 234, "Áo"));
        loadMoreItems.add(new LoadMoreItem(image, 2959002d, "Việt Nam", 234, "Áo"));
        loadMoreItems.add(new LoadMoreItem(image, 2950092d, "Việt Nam", 234, "Áo"));
        loadMoreItems.add(new LoadMoreItem(image, 2950092d, true, "Việt Nam", 234, "Áo", 30.0f));
        loadMoreItems.add(new LoadMoreItem(image, 2959002d, "Việt Nam", 234, "Áo"));
        loadMoreItems.add(new LoadMoreItem(image, 2950092d, "Việt Nam", 234, "Áo"));
        loadMoreItems.add(new LoadMoreItem(image, 2950092d, true, "Việt Nam", 234, "Áo", 30.0f));
        LoadMoreRecy   loadMoreRecy = new LoadMoreRecy(loadMoreItems);
        viewModels.add(loadMoreRecy);
    }

    private void setHot() {
        List<HotWordItem> hotWordItems = new ArrayList<>();
        hotWordItems.add(new HotWordItem("Rau hữu cơ"));
        hotWordItems.add(new HotWordItem("Cá ướp lạnh"));
        hotWordItems.add(new HotWordItem("Thời trang nam"));
        hotWordItems.add(new HotWordItem("Điện thoại"));
        hotWordItems.add(new HotWordItem("Đồ chơi"));
        hotWordItems.add(new HotWordItem("Nồi cơm điện"));
        hotWordItems.add(new HotWordItem("Bàn phím"));
        hotWordItems.add(new HotWordItem("Dụng cụ làm vườn"));
        HotWordRecy hotWordRecy = new HotWordRecy(hotWordItems);
        viewModels.add(hotWordRecy);
    }

    private void setCategory() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem(R.drawable.ic_category_fashion, getResources().getString(R.string.category_fashion)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_mom_baby, getResources().getString(R.string.category_mom_and_son)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_food, getResources().getString(R.string.category_food)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_electrical_devices, getResources().getString(R.string.category_electrics)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_book, getResources().getString(R.string.category_books)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_beauty_health, getResources().getString(R.string.category_beauty)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_accessory, getResources().getString(R.string.category_accessory)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_house_device, getResources().getString(R.string.category_house_device)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_house, getResources().getString(R.string.category_home)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_toys, getResources().getString(R.string.category_games)));
        categoryItems.add(new CategoryItem(R.drawable.ic_category_other, getResources().getString(R.string.category_other)));

        CategoryRecy viewedProductRecy = new CategoryRecy(categoryItems);
        viewModels.add(viewedProductRecy);
    }

    private void setVietnamese() {
        List<RegionProduct> regionProducts = new ArrayList<>();
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "Viet Nam"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "Viet Nam"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "Viet Nam"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "Viet Nam"));
        RegionProductRecy viewedProductRecy = new RegionProductRecy(regionProducts);
        viewModels.add(viewedProductRecy);
    }

    private void setJapanese() {
        List<RegionProduct> regionProducts = new ArrayList<>();
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "JP"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "JP"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "JP"));
        regionProducts.add(new RegionProduct(image, 98595d, 334, "Áo", "JP"));
        RegionProductRecy viewedProductRecy = new RegionProductRecy(regionProducts);
        viewModels.add(viewedProductRecy);
    }

    private void setViewedProduct() {
        List<ViewedProduct> viewedProducts = new ArrayList<>();
        viewedProducts.add(new ViewedProduct(image));
        viewedProducts.add(new ViewedProduct(image));
        viewedProducts.add(new ViewedProduct(image));
        viewedProducts.add(new ViewedProduct(image));
        ViewedProductRecy viewedProductRecy = new ViewedProductRecy(viewedProducts);
        viewModels.add(viewedProductRecy);
    }

    private void setSaleProduct() {
        List<SaleProduct> saleProducts = new ArrayList<>();
        saleProducts.add(new SaleProduct(image, 40000d, 30.0f));
        saleProducts.add(new SaleProduct(image, 40000d, 30.0f));
        saleProducts.add(new SaleProduct(image, 40000d, 30.0f));
        saleProducts.add(new SaleProduct(image, 40000d, 30.0f));
        SaleProductRecy saleProductRecy = new SaleProductRecy(saleProducts);
        viewModels.add(saleProductRecy);

    }


    private void initRecyclerView() {
        rcvProductList = findViewById(R.id.rcv_product_type_list);
        ProductTypeAdapter adapter = new ProductTypeAdapter(viewModels, this);
        rcvProductList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvProductList.setLayoutManager(linearLayoutManager);

    }

    private void setTopSoldProduct() {
        List<TopSoldProduct> topSoldProducts = new ArrayList<>();
        topSoldProducts.add(new TopSoldProduct(image, 30000d, 123));
        topSoldProducts.add(new TopSoldProduct(image, 30000d, 123));
        topSoldProducts.add(new TopSoldProduct(image, 30000d, 123));
        topSoldProducts.add(new TopSoldProduct(image, 30000d, 123));
        topSoldProducts.add(new TopSoldProduct(image, 30000d, 123));
        TopProductRecy topProductRecy = new TopProductRecy(topSoldProducts);
        viewModels.add(topProductRecy);
    }

    private void setBanner() {
        List<BannerItem> bannerItems = new ArrayList<>();
        bannerItems.add(new BannerItem(R.drawable.banner1));
        bannerItems.add(new BannerItem(R.drawable.banner2));
        bannerItems.add(new BannerItem(R.drawable.banner3));
        bannerItems.add(new BannerItem(R.drawable.banner4));

        BannerRecy bannerRecy = new BannerRecy(bannerItems);
        viewModels.add(bannerRecy);
    }


}