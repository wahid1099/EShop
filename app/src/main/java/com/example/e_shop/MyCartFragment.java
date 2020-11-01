package com.example.e_shop;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {
    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;

    public MyCartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View view=inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        continueBtn=view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(linearLayoutManager);
        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.drawable.dal, "Robin Toor Dal", 2, "Rs. 659/-", "759/-", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.flour, "Aashirvaad Aata", 0, "Rs. 459/-", "549/-", 1, 1, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.biscuit, "Cadbury Cookies", 2, "Rs. 80/-", "120/-", 1, 2, 0));
        cartItemModelList.add(new CartItemModel(1, "Price (3) items", "Rs.1198/-", "Free", "Rs.1198/-", "Rs. 230/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getContext(),AddadressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;
    }

}
