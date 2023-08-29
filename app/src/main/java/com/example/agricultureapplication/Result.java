package com.example.agricultureapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Result extends AppCompatActivity {

    private EditText editTextResultN;
    private EditText editTextResultK;
    private EditText editTextResultP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        editTextResultN = findViewById(R.id.editTextN);
        editTextResultK = findViewById(R.id.editTextK);
        editTextResultP = findViewById(R.id.editTextP);

        Intent intent = getIntent();
        double resultN = intent.getDoubleExtra("resultN", 0.0);
        double resultK = intent.getDoubleExtra("resultK", 0.0);
        double resultP = intent.getDoubleExtra("resultP", 0.0);

        String formattedValueN = String.format("%.1f", resultN);
        String formattedValueK = String.format("%.1f", resultN);
        String formattedValueP = String.format("%.1f", resultN);

        editTextResultN.setText(formattedValueN);
        editTextResultK.setText(formattedValueK);
        editTextResultP.setText(formattedValueP);

        // Установите полученный результат в EditText
        editTextResultN.setText(String.valueOf(formattedValueN));
        editTextResultK.setText(String.valueOf(formattedValueK));
        editTextResultP.setText(String.valueOf(formattedValueP));

        Typeface customFont = ResourcesCompat.getFont(this, R.font.comfortaa);
        Typeface customFontButton = ResourcesCompat.getFont(this, R.font.comfortaa_big);

        EditText editTextN = findViewById(R.id.editTextN);
        EditText editTextK = findViewById(R.id.editTextK);
        EditText editTextP = findViewById(R.id.editTextP);
        TextView textViewN = findViewById(R.id.textViewN);
        TextView textViewK = findViewById(R.id.textViewK);
        TextView textViewP = findViewById(R.id.textViewP);
        textViewN.setTypeface(customFont);
        textViewK.setTypeface(customFont);
        textViewP.setTypeface(customFont);
        editTextP.setTypeface(customFont);
        editTextK.setTypeface(customFont);
        editTextP.setTypeface(customFont);
    }
}