package com.example.pasardatosapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Recibir los datos enviados desde RegisterActivity
        String userName = getIntent().getStringExtra("USER_NAME");
        String userPassword = getIntent().getStringExtra("USER_PASSWORD");

        // Asegúrate de que los datos no sean null
        if (userName == null || userPassword == null) {
            throw new RuntimeException("Error: Datos no recibidos correctamente");
        }

        // Mostrar los datos en el TextView
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Bienvenido, " + userName + "\nTu contraseña es " + userPassword);
    }
}