package com.example.pasardatosapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etId = findViewById(R.id.etId);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        // Asegúrate de que btnRegister no sea null
        if (btnRegister == null || etId == null || etPassword == null) {
            throw new RuntimeException("Error: Algún elemento de la interfaz es null");
        }

        btnRegister.setOnClickListener(v -> {
            String id = etId.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (id.isEmpty() || password.isEmpty()) {
                etId.setError("ID requerido");
                etPassword.setError("Password requerido");
                return;
            }

            // Pasar los datos a la siguiente actividad
            Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
            intent.putExtra("USER_NAME", id);  // Pasa el nombre
            intent.putExtra("USER_PASSWORD", password);  // Pasa la contraseña
            startActivity(intent);
        });
    }
}