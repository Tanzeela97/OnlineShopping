package com.example.onlineshopingapp.adaptor;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.productdetail.ProductDetail;
import com.example.onlineshopingapp.databinding.ProductItemBinding;
import com.example.onlineshopingapp.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;
    ProductItemBinding bindProduct;
    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         bindProduct= DataBindingUtil.inflate(inflater, R.layout.product_item, null, false);

        //View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(bindProduct);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

       holder.productItemBinding.prodImg.setImageResource(productsList.get(position).getImageUrl());
        holder.productItemBinding.prodName.setText(productsList.get(position).getProductName());
        holder.productItemBinding.prodQty.setText(productsList.get(position).getProductQty());
        holder.productItemBinding.prodPrice.setText(productsList.get(position).getProductPrice());

        holder.productItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductDetail.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(bindProduct.prodImg, "image");

                //ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {


        ImageView prodImageImg;
        TextView prodNameTxt, prodQtyTxt, prodPriceTxt;
       public ProductItemBinding productItemBinding;
        public ProductViewHolder(@NonNull ProductItemBinding productItemBindingLayout) {
            super(productItemBindingLayout.getRoot());
          productItemBinding=  productItemBindingLayout;

            prodImageImg = productItemBinding.prodImg;

            //prodImage = itemView.findViewById(R.id.prod_img);
            prodNameTxt = productItemBinding.prodName;
            prodPriceTxt = productItemBinding.prodPrice;
            prodQtyTxt = productItemBinding.prodQty;


        }
    }


}

