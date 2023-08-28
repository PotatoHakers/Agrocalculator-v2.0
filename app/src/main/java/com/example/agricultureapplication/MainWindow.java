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
                    editTextContentK.setText("105");
                    editTextContentP.setText("34");
                } else if (selectedValue.equals("Витебская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("105");
                    editTextContentP.setText("34");
                } else if (selectedValue.equals("Гомельская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("3.5");
                    editTextSoilAcidity.setText("7.5");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Гродненская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Минская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Могилеская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("32");
                    editTextContentP.setText("80");
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


        sownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = parent.getItemAtPosition(position).toString();

                if (selectedValue.equals("Брестская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("3.5");
                    editTextSoilAcidity.setText("7.5");
                    editTextContentK.setText("105");
                    editTextContentP.setText("34");
                } else if (selectedValue.equals("Витебская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("105");
                    editTextContentP.setText("34");
                } else if (selectedValue.equals("Гомельская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("3.5");
                    editTextSoilAcidity.setText("7.5");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Гродненская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Минская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("80");
                    editTextContentP.setText("32");
                } else if (selectedValue.equals("Могилеская область")) {
                    editTextSoilDensity.setText("1.2");
                    editTextTopsoilThickness.setText("20");
                    editTextHumusContent.setText("2.2");
                    editTextSoilAcidity.setText("5.3");
                    editTextContentK.setText("32");
                    editTextContentP.setText("80");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Ничего не делаем
            }
        });

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

        spinner = findViewById(R.id.regionSpinner);
        buttonResult = findViewById(R.id.buttonCalculate);

        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add("Брестская область");
        spinnerItems.add("Витебская область");
        spinnerItems.add("Гомельская область");
        spinnerItems.add("Гродненская область");
        spinnerItems.add("Минская область");
        spinnerItems.add("Могилеская область");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получите выбранное значение из Spinner
                String selectedItem = regionSpinner.getSelectedItem().toString();

                // Получите значения из EditText
                double value1 = Double.parseDouble(editTextSquare.getText().toString());
                double value2 = Double.parseDouble(editTextPlannedHarvest.getText().toString());
                double value3 = Double.parseDouble(editTextSoilDensity.getText().toString());
                double value4 = Double.parseDouble(editTextTopsoilThickness.getText().toString());
                double value5 = Double.parseDouble(editTextHumusContent.getText().toString());
                double value6 = Double.parseDouble(editTextSoilAcidity.getText().toString());
                double value7 = Double.parseDouble(editTextContentK.getText().toString());
                double value8 = Double.parseDouble(editTextContentP.getText().toString());
                double value9 = Double.parseDouble(editTextContentN.getText().toString());

                // Выполните расчёты (например, умножение)
                double result;

                if (selectedItem.equals("Пшеница озимая")) {
                    // Выполните расчёт умножения
                    result = value1 * value2;

                    // Создайте Intent для перехода к новой активити
                    Intent intent = new Intent(MainWindow.this, Result.class);
                    intent.putExtra("result", result);
                    startActivity(intent);
                } else if (selectedItem.equals("Пшеница яровая")) {

                }
            }
        });
    }
}

