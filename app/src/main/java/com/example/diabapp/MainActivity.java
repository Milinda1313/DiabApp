package com.example.diabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button jLoginBtn;
    EditText jLoginUsername,jLoginPassword;
    TextView jLoginRegisterLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casting();
        loginBtnAction();

    }

    public void casting()
    {
        jLoginUsername = findViewById(R.id.aLoginUsername);
        jLoginPassword = findViewById(R.id.aLoginPassword);
        jLoginBtn = findViewById(R.id.aLoginBtn);
        jLoginRegisterLbl = findViewById(R.id.aRegisterLbl);
    }

    //Register btn click action
    public void loginBtnAction()
    {
        jLoginBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validate();
                    }
                }
        );
    }

    public void validate()
    {
        String username = jLoginUsername.getText().toString().trim();
        String password = jLoginPassword.getText().toString().trim();

        if(username.equals("")||password.equals(""))
        {
            Toast.makeText(MainActivity.this,"Credentials cannot be empty",Toast.LENGTH_LONG).show();
        }
        else if(username.equals("doctor")&&password.equals("1234"))
        {
            Toast.makeText(MainActivity.this,"Doctor - Successful",Toast.LENGTH_LONG).show();
            goToDoctor();
        }
        else if(username.equals("nurse")&&password.equals("1234"))
        {
            Toast.makeText(MainActivity.this,"Nurse - Successful",Toast.LENGTH_LONG).show();
            goToNurse();
        }
        else
        {
            Toast.makeText(MainActivity.this,"invalid credentials",Toast.LENGTH_LONG).show();
        }

    }

    public void goToNurse()
    {
        Intent intent = new Intent(this, NursesActivity.class);
        startActivity(intent);
    }

    public void goToDoctor()
    {
        Intent intent = new Intent(this, DoctorsScreen.class);
        startActivity(intent);
    }






}
