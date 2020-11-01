package com.example.e_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CatogeryActivity extends AppCompatActivity {
RecyclerView srcolllayoutRecylcerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogery);
        srcolllayoutRecylcerview=findViewById(R.id.catogery_recyclerview);
    }
}