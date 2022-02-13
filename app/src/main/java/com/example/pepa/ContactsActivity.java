package com.example.pepa;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ContactsActivity extends AppCompatActivity {
    public native String getAllContact();

    String allContacts = getAllContact();
    String[] contacts = allContacts.split(" ");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);

        ListView countriesList = findViewById(R.id.countriesList);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, contacts);

        countriesList.setAdapter(adapter);

        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String selectedItem = contacts[position];

                Intent intent3 = new Intent(ContactsActivity.this, Contact.class);
                intent3.putExtra("name", selectedItem);
                startActivity(intent3);

            }
        });
    }

}

