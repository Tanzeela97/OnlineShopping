package com.example.onlineshopingapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.adaptor.ProductAdapter;
import com.example.onlineshopingapp.adaptor.ProductCategoryAdapter;
import com.example.onlineshopingapp.databinding.ActivityMainBinding;
import com.example.onlineshopingapp.model.ProductCategory;
import com.example.onlineshopingapp.model.Products;
import com.example.onlineshopingapp.util.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecyclerview;
    ProductAdapter productAdapter;
    RecyclerView productItemRecyclerview;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

     binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       // setContentView(R.layout.activity_main);


//        imageView = findViewById(R.id.prod_image);

        //mText = (TextView)findViewById(R.id.text);
//        List<ProductCategory> productCategoryList = new ArrayList<>();
//        productCategoryList.add(new ProductCategory(1, "Popular Product"));
//        productCategoryList.add(new ProductCategory(2, "Body Product"));
//        productCategoryList.add(new ProductCategory(3, "Skincare"));
//        productCategoryList.add(new ProductCategory(4, "Hair"));
//        productCategoryList.add(new ProductCategory(5, "Eye Product"));
//        productCategoryList.add(new ProductCategory(6, "Make Up"));
//        productCategoryList.add(new ProductCategory(7, "Fragrance"));

        setProductRecyclerview(DataSource.getProductCategorylist());

        setProdItemRecycler(DataSource.getProductlist());
     //   loadDataFromAsset();

    }



//    public void loadDataFromAsset() {
//        // load text
//        try {
//            // get input stream for text
//            InputStream is = getAssets().open("text.txt");
//            // check size
//            int size = is.available();
//            // create buffer for IO
//            byte[] buffer = new byte[size];
//            // get data to buffer
//            is.read(buffer);
//            // close stream
//            is.close();
//            // set result to TextView
//            //mText.setText(new String(buffer));
//        } catch (IOException ex) {
//            return;
//        }
//
//        // load image
//        try {
//            // get input stream
//            InputStream ims = getAssets().open("product1.jpg");
//            // load image as Drawable
//            Drawable d = Drawable.createFromStream(ims, null);
//            // set image to ImageView
//            imageView.setImageDrawable(d);
//        } catch (IOException ex) {
//            return;
//        }
//    }


    private void setProductRecyclerview(List<ProductCategory> productCategoryList) {
        productCatRecyclerview = binding.catRecycler;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.catRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        binding.catRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProdItemRecycler(List<Products> productsList) {
        productItemRecyclerview = binding.productRecycler;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.productRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        binding.productRecycler.setAdapter(productAdapter);

    }
}