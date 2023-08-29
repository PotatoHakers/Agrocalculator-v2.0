package com.example.agricultureapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends AppCompatActivity {

    private Button buttonResult;
    private TextView regionEditText;
    private Spinner regionSpinner;
    private Spinner mechanicalCompositionSoil;
    private EditText editTextSquare;
    private EditText editTextPlannedHarvest;
    private EditText editTextSoilDensity;
    private EditText editTextTopsoilThickness;
    private EditText editTextHumusContent;
    private EditText editTextSoilAcidity;
    private int selectedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);

        Spinner spinner = findViewById(R.id.regionSpinner);
        EditText editTextSquare = findViewById(R.id.editTextSquare);
        EditText editTextPlannedHarvest = findViewById(R.id.editTextPlannedHarvest);
        EditText editTextSoilDensity = findViewById(R.id.editTextSoilDensity);
        EditText editTextTopsoilThickness = findViewById(R.id.editTextTopsoilThickness);
        EditText editTextHumusContent = findViewById(R.id.editTextHumusContent);
        EditText editTextSoilAcidity = findViewById(R.id.editTextSoilAcidity);
        EditText editTextContentKSoil = findViewById(R.id.editTextContentK2OSoil);
        EditText editTextContentPSoil = findViewById(R.id.editTextContentP2O5Soil);
        EditText editTextContentNSoil = findViewById(R.id.editTextContentNSoil);
        EditText editTextContentK = findViewById(R.id.editTextContentK2O);
        EditText editTextContentP = findViewById(R.id.editTextContentP2O5);
        EditText editTextContentN = findViewById(R.id.editTextContentN);

        ImageView imageViewFiledOption = findViewById(R.id.imageViewFieldOption);
        imageViewFiledOption.setImageResource(R.drawable.distance);

        ImageView imageViewCulture = findViewById(R.id.imageViewCulture);
        imageViewCulture.setImageResource(R.drawable.psychiatry);

        ImageView imageViewSoil = findViewById(R.id.imageViewSoil);
        imageViewSoil.setImageResource(R.drawable.area_chart);

        ImageView imageViewChemComp = findViewById(R.id.imageViewChemComp);
        imageViewChemComp.setImageResource(R.drawable.list_alt);

        Spinner regionSpinner = findViewById(R.id.regionSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.belarus_regions,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        regionSpinner.setAdapter(adapter);

        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean initialSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (initialSelection) {
                    initialSelection = false;
                } else {
                    String selectedRegion = parent.getItemAtPosition(position).toString();
                    DataHolder.getInstance().setSelectedRegion(selectedRegion);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = parent.getItemAtPosition(position).toString();

                if (selectedValue.equals("Брестская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("3.5");
                    editTextSoilAcidity.setText("7.5");
                    editTextContentKSoil.setText("105");
                    editTextContentPSoil.setText("34");
                } else if (selectedValue.equals("Витебская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentKSoil.setText("105");
                    editTextContentPSoil.setText("34");
                } else if (selectedValue.equals("Гомельская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("3.5");
                    editTextSoilAcidity.setText("7.5");
                    editTextContentKSoil.setText("80");
                    editTextContentPSoil.setText("32");
                } else if (selectedValue.equals("Гродненская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentKSoil.setText("80");
                    editTextContentPSoil.setText("32");
                } else if (selectedValue.equals("Минская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentKSoil.setText("80");
                    editTextContentPSoil.setText("32");
                } else if (selectedValue.equals("Могилеская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentKSoil.setText("80");
                    editTextContentPSoil.setText("32");
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Ничего не делаем
            }
        });

        Spinner sownSpinner = findViewById(R.id.sownSpinner);

        ArrayAdapter<CharSequence> adapterSown = ArrayAdapter.createFromResource(
                this,
                R.array.culture,
                android.R.layout.simple_spinner_item
        );
        adapterSown.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sownSpinner.setAdapter(adapterSown);

        TextView textView = findViewById(R.id.textViewFieldOption);
        TextView textView1 = findViewById(R.id.textViewCulture);
        TextView textView2 = findViewById(R.id.textViewSoilAcidity);
        TextView textView3 = findViewById(R.id.textViewDegreeInfestation);
        TextView textView4 = findViewById(R.id.textViewHumusContent);
        TextView textView5 = findViewById(R.id.textViewSoil);
        TextView textView6 = findViewById(R.id.textViewTopsoilThickness);
        TextView textView7 = findViewById(R.id.textViewSoilDensity);
        TextView textView8 = findViewById(R.id.textViewPlannedHarvest);
        TextView textView9 = findViewById(R.id.textViewSquare);
        TextView textView10 = findViewById(R.id.textViewChemComp);
        TextView textView11 = findViewById(R.id.textViewContentN);
        TextView textView12 = findViewById(R.id.textViewContentK20);
        TextView textView13 = findViewById(R.id.textViewContentP2O5);
        TextView textView14 = findViewById(R.id.textViewMehanicalCompositionSoil);
        TextView textView15 = findViewById(R.id.textViewSownCulture);
        TextView textView16 = findViewById(R.id.textRegion);
        TextView textView17 = findViewById(R.id.textViewContentNSoil);
        TextView textView18 = findViewById(R.id.textViewContentK2OSoil);
        TextView textView19 = findViewById(R.id.textViewContentP2O5Soil);

        Button buttonBack = findViewById(R.id.buttonReset);
        Button buttonResult = findViewById(R.id.buttonCalculate);

        Typeface customFont = ResourcesCompat.getFont(this, R.font.comfortaa);
        Typeface customFontButton = ResourcesCompat.getFont(this, R.font.comfortaa_big);


        textView.setTypeface(customFont);
        textView1.setTypeface(customFont);
        textView2.setTypeface(customFont);
        textView3.setTypeface(customFont);
        textView4.setTypeface(customFont);
        textView5.setTypeface(customFont);
        textView6.setTypeface(customFont);
        textView7.setTypeface(customFont);
        textView8.setTypeface(customFont);
        textView9.setTypeface(customFont);
        textView10.setTypeface(customFont);
        textView11.setTypeface(customFont);
        textView12.setTypeface(customFont);
        textView13.setTypeface(customFont);
        textView14.setTypeface(customFont);
        textView15.setTypeface(customFont);
        textView16.setTypeface(customFont);
        textView17.setTypeface(customFont);
        textView18.setTypeface(customFont);
        textView19.setTypeface(customFont);
        buttonBack.setTypeface(customFontButton);
        buttonResult.setTypeface(customFontButton);
        editTextSquare.setTypeface(customFont);
        editTextSoilDensity.setTypeface(customFont);
        editTextTopsoilThickness.setTypeface(customFont);
        editTextHumusContent.setTypeface(customFont);
        editTextSoilAcidity.setTypeface(customFont);
        editTextContentK.setTypeface(customFont);
        editTextContentP.setTypeface(customFont);


        Spinner mechanicalCompositionSoil = findViewById(R.id.spinnerMehanicalCompositionSoil);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.mechanical_composition_soil,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mechanicalCompositionSoil.setAdapter(adapter2);

        mechanicalCompositionSoil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean initialSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (initialSelection) {
                    initialSelection = false;
                } else {
                    String selectedRegion = parent.getItemAtPosition(position).toString();
                    DataHolder.getInstance().setSelectedRegion(selectedRegion);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        Spinner spinnerDegreeInfestation = findViewById(R.id.spinnerDegreeInfestation);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.degree_infestation,
                android.R.layout.simple_spinner_item
        );
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDegreeInfestation.setAdapter(adapter3);

        spinnerDegreeInfestation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean initialSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (initialSelection) {
                    initialSelection = false;
                } else {
                    String selectedRegion = parent.getItemAtPosition(position).toString();
                    DataHolder.getInstance().setSelectedRegion(selectedRegion);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        Button clearButton = findViewById(R.id.buttonReset);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regionSpinner.setSelection(0);
                spinnerDegreeInfestation.setSelection(0);
                mechanicalCompositionSoil.setSelection(0);

                editTextSquare.setText("");
                editTextPlannedHarvest.setText("");
                editTextSoilDensity.setText("");
                editTextTopsoilThickness.setText("");
                editTextHumusContent.setText("");
                editTextSoilAcidity.setText("");

            }
        });

        spinner = findViewById(R.id.sownSpinner);
        buttonResult = findViewById(R.id.buttonCalculate);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.culture, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получите выбранное значение из Spinner
                String selectedItem = sownSpinner.getSelectedItem().toString();

                // Получите значения из EditText
                double value1 = Double.parseDouble(editTextSquare.getText().toString());
                double value2 = Double.parseDouble(editTextPlannedHarvest.getText().toString());
                double value3 = Double.parseDouble(editTextContentNSoil.getText().toString());
                double value4 = Double.parseDouble(editTextTopsoilThickness.getText().toString());
                double value5 = Double.parseDouble(editTextSoilDensity.getText().toString());
                double value6 = Double.parseDouble(editTextHumusContent.getText().toString());
                double value7 = Double.parseDouble(editTextSoilAcidity.getText().toString());
                double value8 = Double.parseDouble(editTextContentN.getText().toString());
                double value9 = Double.parseDouble(editTextContentKSoil.getText().toString());
                double value10 = Double.parseDouble(editTextContentK.getText().toString());
                double value11 = Double.parseDouble(editTextContentP.getText().toString());
                double value12 = Double.parseDouble(editTextContentPSoil.getText().toString());

                if (selectedItem.equals("Пшеница озимая"))
                {
                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.53) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.20) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.85) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);
                }else if (selectedItem.equals("Пшеница яровая"))
                {
                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.54) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.21) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.86) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);
                }else if (selectedItem.equals("Рожь озимая")){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.53) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.20) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.85) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Овес"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.50) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.37) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.74) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Ячмень яровой"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.47) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.42) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.81) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Ячмень озимый"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.31) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.34) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.75) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Гречиха"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.39) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.44) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.69) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Кукуруза"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.32) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.43) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.84) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Рис"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.37) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.39) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.73) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Рапс озимый"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.50) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.36) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.82) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Рапс яровой"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.42) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.43) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.83) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Соя"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.49) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.48) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.80) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Лен масличный"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.44) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.45) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.70) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Хлопчатник"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.34) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.39) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.79) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Лен"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.46) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.45) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.81) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Сахарная свекла"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.40) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.38) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.80) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Морковь"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.39) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.40) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.64) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Капуста"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.38) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.33) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.62) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Томат"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.48) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.34) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.64) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Перец"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.37) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.44) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.83) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Огурец"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.44) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.37) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.61) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Кабачок"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.45) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.35) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.72) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Лук репчатый"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.36) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.42) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.74) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Картофель"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.41) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.20) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.75) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Тыква"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.35) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.22) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.72) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Арбуз"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.50) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.21) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.61) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Дыня"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.45) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.29) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.83) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Клубника"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.35) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.40) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.64) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Голубика"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.35) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.31) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.65) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Смородина"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.30) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.29) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.80) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);

                }else if (selectedItem.equals(("Малина"))){

                    double resultN = ((value1 * value2 * (value3*0.25)) - ((value4 * value5) * value6 * value7)) / ((value8*0.40) * 1.01);

                    double resultK = ((value1 * value2 * (value9*0.25)) - ((value4 * value5) * value6 * value7)) / ((value10*0.41) * 1.01);

                    double resultP = ((value1 * value2 * (value12*0.25)) - ((value4 * value5) * value6 * value7)) / ((value11*0.62) * 1.01);

                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("resultN", resultN);
                    intent.putExtra("resultK", resultK);
                    intent.putExtra("resultP", resultP);
                    startActivity(intent);
                }
            }

        });
    }
}
