package com.example.pepa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.pepa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.pepa.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button buildButton = findViewById(R.id.buildButton);
        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });
        Button contactButton = findViewById(R.id.contactBtn);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(intent2);
            }
        });
        Button addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, addContact.class);
                startActivity(intent4);
            }
        });
        Button findBtn = findViewById(R.id.findButton1);
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, findContact.class);
                startActivity(intent5);
            }
        });

    }

    static {
        System.loadLibrary("pepa");
    }
}