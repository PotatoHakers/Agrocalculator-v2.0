package com.example.agricultureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private EditText editTextResult;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result);

            editTextResult = findViewById(R.id.editTextN);

            Intent intent = getIntent();
            double result = intent.getDoubleExtra("result", 0.0);

            editTextResult.setText(String.valueOf(result));
        }
    }
