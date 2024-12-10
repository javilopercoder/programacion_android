package com.example.tareaswitch;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los componentes
        Switch switchDatos = findViewById(R.id.switchDatos);
        Switch switchWifi = findViewById(R.id.switchWifi);
        Button btnComprobar = findViewById(R.id.btnComprobar);

        // Listener para el botón
        btnComprobar.setOnClickListener(view -> {
            boolean datosActivos = switchDatos.isChecked();
            boolean wifiActivo = switchWifi.isChecked();

            // Mostrar el estado en un Toast
            String mensaje;
            if (datosActivos && wifiActivo) {
                mensaje = "Datos móviles y conexión WiFi activados.";
            } else if (datosActivos) {
                mensaje = "Datos móviles activados.";
            } else if (wifiActivo) {
                mensaje = "Conexión WiFi activada.";
            } else {
                mensaje = "Datos móviles y Wifi desactivados";
            }

            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        });
    }
}
