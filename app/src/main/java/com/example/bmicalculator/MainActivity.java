package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SubmitButton = findViewById(R.id.buttonToSubmit);
        //  Button resetButton = findViewById(R.id.reset);
        EditText weightView = findViewById(R.id.weightInKg);
        EditText heightInFeetView = findViewById(R.id.heightInFeet);
        EditText heightInInchesView = findViewById(R.id.heightInInches);
        TextView result = findViewById(R.id.result);

        SubmitButton.setOnClickListener(view -> {
            try {
                int weight = Integer.parseInt(weightView.getText().toString());
                int heightInFeet = Integer.parseInt(heightInFeetView.getText().toString());
                int heightInInches = Integer.parseInt(heightInInchesView.getText().toString());

                int heightFromFeetToInches = heightInFeet * 12;
                int totalHeightInInches = heightFromFeetToInches + heightInInches;
                double heightInMeters = totalHeightInInches * 0.0254;
                double bmi = weight / (heightInMeters * heightInMeters);

                if (bmi < 25) {
                    result.setText("" + bmi);
                }
                if (bmi > 25) {
                    result.setText("" + bmi);
                }
                if (bmi < 20) {
                    result.setText("" + bmi);
                }
            } catch (Exception e) {
                Toast.makeText(this, "Please Enter Valid data", Toast.LENGTH_LONG).show();
            }
        });

        /*
        button1.setOnClickListener(view -> {
            finish();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

        });
        */

    }
}