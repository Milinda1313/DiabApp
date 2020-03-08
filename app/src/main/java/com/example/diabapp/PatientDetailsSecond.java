package com.example.diabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.diabapp.constants.Constatnts;

public class PatientDetailsSecond extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    Spinner jMaritalSpinner, jFoodPatternSpinner;
    Button jPatientDetailsNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details_second);
        casting();

        nextBtnClick();

        jMaritalSpinner.setOnItemSelectedListener(this);
        jFoodPatternSpinner.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter marital = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Constatnts.MARITAL);
        marital.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        jMaritalSpinner.setAdapter(marital);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter food = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Constatnts.FOOD_PATTERN);
        food.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        jFoodPatternSpinner.setAdapter(food);


    }


    public void casting() {
        jPatientDetailsNextBtn = findViewById(R.id.aPatientDetailsNext);
        jMaritalSpinner = findViewById(R.id.aMaritalSpinner);
        jFoodPatternSpinner = findViewById(R.id.aFoodPatternSpinner);
    }

    public void nextBtnClick()
    {
        jPatientDetailsNextBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moveToNextPage();
                    }
                }
        );
    }

    public void moveToNextPage()
    {
        Intent intent = new Intent(this, QuestionsScreen.class);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
