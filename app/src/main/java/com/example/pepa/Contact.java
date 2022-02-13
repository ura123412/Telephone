package com.example.pepa;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Contact extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        TextView name = findViewById(R.id.contact_name);
        TextView number = findViewById(R.id.contact_number);

        Bundle arguments = getIntent().getExtras();
        String textName = arguments.getString("name");

        name.setText("Имя: " + textName);
        number.setText("Номер :  " + takeContact(textName));
    }

    public native String takeContact(String name);

}
