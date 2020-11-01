package com.example.e_shop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class catogery_adapter extends RecyclerView.Adapter<catogery_adapter.ViewHolder> {
    private List<catogery_model> catogery_modelList;

    public catogery_adapter(List<catogery_model> catogery_modelList) {
        this.catogery_modelList = catogery_modelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.catogery_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int icon=catogery_modelList.get(position).getCatoger_iconlink();
        String name=catogery_modelList.get(position).getCatogery_name();
        holder.setCatogery(name);
    }

    @Override
    public int getItemCount() {
        return catogery_modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView catogeryIcon;
        private TextView catogeryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catogeryIcon=itemView.findViewById(R.id.catogaery_icon);
            catogeryName=itemView.findViewById(R.id.catogery_name);
        }
        private void setCatogeryIcon(){
            //todo set catogery icons

        }
        private void setCatogery(final String name){
            catogeryName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent catogeryintent=new Intent(itemView.getContext(),CatogeryActivity.class);
                    catogeryintent.putExtra("catogeryName",name);
                    itemView.getContext().startActivity(catogeryintent);

                }
            });
        }
    }
}
