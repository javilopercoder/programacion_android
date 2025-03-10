package com.example.pasardatosapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etLoginId = findViewById(R.id.etLoginId);
        EditText etLoginPassword = findViewById(R.id.etLoginPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
            intent.putExtra("ID", etLoginId.getText().toString());
            intent.putExtra("PASSWORD", etLoginPassword.getText().toString());
            startActivity(intent);
        });
    }
}