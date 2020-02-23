package com.example.diabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.diabapp.constants.Constatnts;

public class NursesActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    Spinner jGender;
    Button jPatientBasicNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses);
        casting();
        setGenderAdapter();
        patientNextBtnClick();
    }

    public void setGenderAdapter()
    {
        jGender.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Constatnts.GENDER);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        jGender.setAdapter(aa);
    }

    public void casting()
    {
        jGender = findViewById(R.id.aGenderSpinner);
        jPatientBasicNext = findViewById(R.id.aPatientBasicNext);
    }

    public void patientNextBtnClick(){
        jPatientBasicNext.setOnClickListener(
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
        Intent intent = new Intent(this, PatientDetailsSecond.class);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Constatnts.GENDER[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
