package com.example.e_shop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder>  {
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_product_scroll_itemlayout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewHolder, int position) {
        String resource = horizontalProductScrollModelList.get(position).getProductImage();
        String title = horizontalProductScrollModelList.get(position).getProductTitle();
        String description = horizontalProductScrollModelList.get(position).getProductDescription();
        String price = horizontalProductScrollModelList.get(position).getProductPrice();
        viewHolder.setData(resource, title, description, price);
/*        holder.setProductImage(resoure);
        holder.setProductPrice(title);
        holder.setProductDiscription(description);
        holder.setProductPrice(price);
    }*/
    }

    @Override
    public int getItemCount() {
        if(horizontalProductScrollModelList.size() > 8){
            return 8;
        }else {
            return horizontalProductScrollModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle, productDescription, productPrice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productdetailsintent= new Intent(itemView.getContext(),Product_detail_Activity.class);
                    itemView.getContext().startActivity(productdetailsintent);
                }
            });
        }
       /* public void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        public void setProductTitle(String title){
            productTitle.setText(title);
        }
        public void setProductDiscription(String descriptiom){
            productDiscription.setText(descriptiom);
        }
        public void setProductPrice(String price){
            productPrice.setText(price);
        }*/
       private void setData(String resource,String title,String description,String price){
           Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.mipmap.custom_error_icon)).into(productImage);
           productPrice.setText("Rs."+price+"/-");
           productDescription.setText(description);
           productTitle.setText(title);
           if(!title.equals("")) {
               itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent productDetailsIntent = new Intent(itemView.getContext(), Product_detail_Activity.class);
                       itemView.getContext().startActivity(productDetailsIntent);
                   }
               });
           }
       }

    }

}
