package com.example.onlineshopingapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.databinding.CategoryItemBinding;
import com.example.onlineshopingapp.model.ProductCategory;
import com.example.onlineshopingapp.model.Products;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductViewHolder> {


    Context context;
    List<ProductCategory> productCategoryList;
    CategoryItemBinding bindCat;
    public ProductCategoryAdapter(Context context, List<ProductCategory> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       bindCat= DataBindingUtil.inflate(inflater, R.layout.category_item, null, false);

     //View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ProductViewHolder(bindCat);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryAdapter.ProductViewHolder holder, int position) {
       holder.categoryItemBinding.catName.setText(productCategoryList.get(position).getProductName());

    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView catagoryName;
public CategoryItemBinding categoryItemBinding;
        public ProductViewHolder(@NonNull CategoryItemBinding categoryItemBindinglayout) {
            super(categoryItemBindinglayout.getRoot());
            categoryItemBinding=categoryItemBindinglayout;
            catagoryName = categoryItemBindinglayout.catName;

        }
    }
}
