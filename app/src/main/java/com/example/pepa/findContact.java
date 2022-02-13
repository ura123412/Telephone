package com.example.pepa;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class findContact extends AppCompatActivity {

    public native String findNumber(String name);

    public native boolean checkContact(String name);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findcontact);

        EditText name = findViewById(R.id.findName);
        Button findBtn = findViewById(R.id.findButton2);
        TextView tv = findViewById(R.id.findNumber);

        String toastText = "Контакта не существует!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplication(), toastText, duration);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strName = name.getText().toString();

                if (checkContact(strName)) {

                    tv.setText(findNumber(strName));
                    tv.setBackgroundColor(Color.rgb(255, 198, 0));

                } else {
                    toast.show();
                }
            }
        });
    }
}
