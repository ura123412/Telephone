package com.example.pepa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class addContact extends AppCompatActivity {

    public native void saveContact(String name , String number);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);

        EditText name = findViewById(R.id.addName);
        EditText number = findViewById(R.id.addNumber);
        Button addBtn = findViewById(R.id.addButton);

        String toastText = "Контакт добавлен!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplication(),toastText,duration);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = name.getText().toString();
                String strNumber = number.getText().toString();

                saveContact(strName,strNumber);

                toast.show();
            }
        });
    }
}
