package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersFragment extends Fragment {
    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrdersRecyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrdersRecyclerView=view.findViewById(R.id. my_orders_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(linearLayoutManager);
        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.poco,2,"Poco F1 256 GB","Delivered on Mon,15th JAN 2019"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.dal,1,"Robin Toor Dal","Delivered on Mon,15th FEB 2019"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.deo,0,"Police Deo","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.perfumes,4,"Pixel 2XL","Delivered on Mon,15th MAR 2019"));
        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;

    }
}