package com.bijoydebnath.hw3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class NewsActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<News> newsArrayList;
    DataSource dataSource;
    private NewsAdapter adapter;
    ListView newsLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        toolbar = findViewById(R.id.toolbar);
        newsLV = findViewById(R.id.newsLV);

        newsArrayList = new ArrayList<>();
        dataSource = new DataSource(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int cId = intent.getIntExtra("cID", 0);
        getSupportActionBar().setTitle(title);

        newsArrayList = dataSource.getNewsById(cId);
        adapter = new NewsAdapter(this, newsArrayList);
        newsLV.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}