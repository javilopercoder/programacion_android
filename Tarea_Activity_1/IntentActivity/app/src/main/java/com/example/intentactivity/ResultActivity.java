package com.example.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView number1Text, number2Text, resultText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        resultText = findViewById(R.id.resultText);
        backButton = findViewById(R.id.backButton);

        // Recibir datos del Intent
        Intent intent = getIntent();
        double num1 = intent.getDoubleExtra("NUMBER1", 0);
        double num2 = intent.getDoubleExtra("NUMBER2", 0);
        double result = intent.getDoubleExtra("RESULT", 0);

        // Mostrar datos en los TextView
        number1Text.setText("Número 1: " + num1);
        number2Text.setText("Número 2: " + num2);
        resultText.setText("Resultado: " + result);

        // Botón para volver a MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la anterior
            }
        });
    }
}
