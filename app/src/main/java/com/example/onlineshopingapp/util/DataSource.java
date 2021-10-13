package com.example.onlineshopingapp.util;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.model.ProductCategory;
import com.example.onlineshopingapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<ProductCategory> getProductCategorylist() {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Popular Product"));
        productCategoryList.add(new ProductCategory(2, "Body Product"));
        productCategoryList.add(new ProductCategory(3, "Skincare"));
        productCategoryList.add(new ProductCategory(4, "Hair"));
        productCategoryList.add(new ProductCategory(5, "Eye Product"));
        productCategoryList.add(new ProductCategory(6, "Make Up"));
        productCategoryList.add(new ProductCategory(7, "Fragrance"));
        return productCategoryList;
    }

    public static List<Products> getProductlist() {

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Soothing Facial form Facewash", "250 ml", "$ 17.00", R.drawable.facewash1));
        productsList.add(new Products(2, "Daily Facial Cleanser Facewash", "350 ml", "$ 25.00", R.drawable.facewash2));
        productsList.add(new Products(1, "Ultra Foundation Invisible cover Foundation", "250 ml", "$ 17.00", R.drawable.foundation1));
        productsList.add(new Products(2, "Elizabeth Arden Flawless Start Instant Perfecting Primer", "350 ml", "$ 25.00", R.drawable.face_premier));
        productsList.add(new Products(1, "Simple Strokes Dual-Ended Eyeliner", "250 ml", "$ 17.00", R.drawable.eyelinear1));
        productsList.add(new Products(2, "Fantacy Eyeshadow Palette #03", "350 ml", "$ 25.00", R.drawable.eyeshade1));
        return productsList;
    }
}
