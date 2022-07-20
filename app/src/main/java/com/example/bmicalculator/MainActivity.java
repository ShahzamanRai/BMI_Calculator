package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonToSubmit);
        Button button1 = findViewById(R.id.reset);
        EditText weightView = findViewById(R.id.weightInKg);
        EditText heightInFeetView = findViewById(R.id.heightInFeet);
        EditText heightInInchesView = findViewById(R.id.heightInInches);
        TextView result = findViewById(R.id.result);
        LinearLayout main11 = findViewById(R.id.mainActivity);

        button.setOnClickListener(view -> {
            try {
                int weight = Integer.parseInt(weightView.getText().toString());
                int heightInFeet = Integer.parseInt(heightInFeetView.getText().toString());
                int heightInInches = Integer.parseInt(heightInInchesView.getText().toString());

                int heightFromFeetToInches = heightInFeet * 12;
                int totalHeightInInches = heightFromFeetToInches + heightInInches;
                double heightInMeters = totalHeightInInches * 0.0254;
                double bmi = weight / (heightInMeters * heightInMeters);

                if (bmi < 25) {
                    result.setText("You're Healthy\nYour BMI is " + bmi);
                    main11.setBackgroundColor(getResources().getColor(R.color.perfect));
                }
                if (bmi > 25) {
                    result.setText("You're OverWeight\nYour BMI is " + bmi);
                    main11.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }
                if (bmi < 20) {
                    result.setText("You're UnderWeight \nYour BMI is " + bmi);
                    main11.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }
            } catch (Exception e) {
                Toast.makeText(this, "Please Enter Valid data", Toast.LENGTH_LONG).show();
            }
        });

        button1.setOnClickListener(view -> {
            finish();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

        });
    }
}