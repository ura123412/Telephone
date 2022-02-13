package com.example.pepa;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BuildActivity extends AppCompatActivity {

    private TextView tv;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_layout);

        tv = findViewById(R.id.tv);

        tv.setText("Версия SDK вашего устройства: " + Build.VERSION.SDK_INT + "\n"
                + "Наименование версии ОС: " + Build.ID + "\n"
                + "Устройство: " + Build.DEVICE + "\n"
                + "Изготовитель: " + Build.MANUFACTURER + "\n"
                + "Модель: " + Build.MODEL + "\n"
        );


    }
}
