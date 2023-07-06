package com.bijoydebnath.hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Category> categoryArrayList;

    Spinner spinner;
    Button checkButton;
    TextView displayTV;

    DataSource dataSource;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.app_name);

        dataSource = new DataSource(this);

        categoryArrayList = new ArrayList<>();
        spinner = findViewById(R.id.spinner);
        checkButton = findViewById(R.id.checkButton);
        displayTV = findViewById(R.id.textView);

        categoryArrayList.clear();
        categoryArrayList = dataSource.getCategories();
//        animalArrayList.add(new Animal(0, "Select One"));
//        animalArrayList.add(new Animal(1, "Lion"));
//        animalArrayList.add(new Animal(3, "Donkey"));
//        animalArrayList.add(new Animal(4, "Leopard"));
//        animalArrayList.add(new Animal(5, "Rabbit"));
//        animalArrayList.add(new Animal(6, "Tortoise"));


        ArrayAdapter<Category> adapter =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, categoryArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        checkButton.setOnClickListener(view -> {
            Category selectedItem = (Category) spinner.getSelectedItem();
            if (selectedItem.getId() == 0) {
                Toast.makeText(this, "Select One Category", Toast.LENGTH_SHORT).show();
                displayTV.setText("");
            } else {
                Intent intent = new Intent(this, NewsActivity.class);
                intent.putExtra("cID", selectedItem.getId());
                intent.putExtra("title", selectedItem.getTitle());
                startActivity(intent);
            }
        });

    }
}