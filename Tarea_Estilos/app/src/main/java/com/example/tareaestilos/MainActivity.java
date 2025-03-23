package com.example.tareaestilos;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Pop", Color.parseColor("#8E44AD")));
        categoryList.add(new Category("Indie", Color.parseColor("#27AE60")));
        categoryList.add(new Category("News & Politics", Color.parseColor("#2980B9")));
        categoryList.add(new Category("Comedy", Color.parseColor("#E74C3C")));
        categoryList.add(new Category("2021 Wrapped", Color.parseColor("#F1C40F")));
        categoryList.add(new Category("Podcast", Color.parseColor("#16A085")));
        categoryList.add(new Category("Made for you", Color.parseColor("#2ECC71")));
        categoryList.add(new Category("Charts", Color.parseColor("#9B59B6")));

        adapter = new CategoryAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
    }
}
