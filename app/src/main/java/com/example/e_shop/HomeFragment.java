package com.example.e_shop;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    //private HomeViewModel homeViewModel;
    private RecyclerView categoryRecyclerView;
 List<catogery_model> categoryModelList ;
    private catogery_adapter categoryAdapter;
    private List<HomepageModel> homePageModelFakeList = new ArrayList<>();
   /* private List<HomepageModel> homePageModelFakeList = new ArrayList<>();
    private RecyclerView homePageRecyclerView;
    private ImageView noInternetConnection;
    private HomepageAdapter adapter;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;*/
   private ViewPager banner_sliderviewpager;
   private List<SliderModel> sliderModelList;
   private int currentpage=2;
    public static SwipeRefreshLayout swipeRefreshLayout;
   private Timer timer;
   final private long DELAY_TIME=2000;
   final private long PERIOD_TIME=2000;
   private HomepageAdapter adapter;
    private ImageView noInternetConnection;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View view= inflater.inflate(R.layout.fragment_home, container, false);


       RecyclerView tesing=view.findViewById(R.id.HomepageRecyclerviewtesting);
       categoryModelList=new ArrayList<>();
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       categoryModelList.add(new catogery_model(R.drawable.ic_baseline_home_24,"home"));
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
       linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
       tesing.setLayoutManager(linearLayoutManager);
       catogery_adapter catogeryAdapter=new catogery_adapter(categoryModelList);

       tesing.setAdapter(catogeryAdapter);
       catogeryAdapter.notifyDataSetChanged();
       ////////Banner slider code
        //////////////////////////////HomePage Fake List

        List<SliderModel> sliderModelFakeList = new ArrayList<>();
        sliderModelFakeList.add(new SliderModel(R.drawable.banner_four, "#FFFFFF"));
        sliderModelFakeList.add(new SliderModel(R.drawable.banner_seven, "#FFFFFF"));
        sliderModelFakeList.add(new SliderModel(R.drawable.banner_one, "#FFFFFF"));
        sliderModelFakeList.add(new SliderModel(R.drawable.banner_three, "#FFFFFF"));

        List<HorizontalProductScrollModel> horizontalProductScrollModelFakeList = new ArrayList<>();
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("", "", "", "", ""));

        homePageModelFakeList.add(new HomepageModel(0, sliderModelFakeList));
        homePageModelFakeList.add(new HomepageModel(1, "", "#FFFFFF"));
        homePageModelFakeList.add(new HomepageModel(2, "", "#FFFFFF", horizontalProductScrollModelFakeList, new ArrayList<WishlistModel>()));
        homePageModelFakeList.add(new HomepageModel(3, "", "#FFFFFF", horizontalProductScrollModelFakeList));

        //////////////////////////////HomePage Fake List
      //  categoryAdapter = new CategoryAdapter(categoryModelFakeList);


        adapter = new HomepageAdapter(homePageModelFakeList);



        connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();


      /*  //if (networkInfo != null && networkInfo.isConnected() == true) {
//            noInternetConnection.setVisibility(View.GONE);


            *//*if (categoryModelList.size() == 0) {
                loadCategories(categoryRecyclerView, getContext());
            } else {
                categoryAdapter =new CategoryAdapter(categoryModelList);
                categoryAdapter.notifyDataSetChanged();
            }

            categoryRecyclerView.setAdapter(categoryAdapter);
            if (lists.size() == 0) {
             *//**//*   loadCategoriesNames.add("HOME");
                lists.add(new ArrayList<HomePageModel>());

                loadFragmentData(homePageRecyclerView, getContext(), 0, "Home");*//**//*
            } else {
              //  adapter = new HomepageAdapter(lists.get(0));
                adapter.notifyDataSetChanged();
            }
          //  homePageRecyclerView.setAdapter(adapter);*//*

        } else {
            Glide.with(this).load(R.drawable.no_internet_connection).into(noInternetConnection);
            noInternetConnection.setVisibility(View.VISIBLE);
        }


        ///////// Refresh Layout
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayout.setRefreshing(true);
                categoryModelList.clear();
               *//* lists.clear();
                loadCategoriesNames.clear();*//*
                if (networkInfo != null && networkInfo.isConnected() == true) {
                    noInternetConnection.setVisibility(View.GONE);
                *//*  //  categoryAdapter = new CategoryAdapter(categoryModelFakeList);
                    adapter = new HomePageAdapter(homePageModelFakeList);
                    categoryRecyclerView.setAdapter(categoryAdapter);
                    homePageRecyclerView.setAdapter(adapter);
                    loadCategories(categoryRecyclerView, getContext());
                    loadCategoriesNames.add("HOME");
                    lists.add(new ArrayList<HomePageModel>());
                    loadFragmentData(homePageRecyclerView, getContext(), 0, "Home");*//*

                } else {
                    Glide.with(getContext()).load(R.drawable.no_internet_connection).into(noInternetConnection);
                    noInternetConnection.setVisibility(View.VISIBLE);
                }

            }
        });

        ///////// Refresh Layout*/
        return view;
    }

    ///////////////////BANNER SLIDER


}
