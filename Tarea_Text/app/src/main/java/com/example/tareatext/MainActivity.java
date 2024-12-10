package com.example.tareatext;  // Verifica que el paquete sea este

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos del layout
        EditText editText = findViewById(R.id.editText);
        Button btnShowToast = findViewById(R.id.btnShowToast);

        // Configurar el evento de clic del botón
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del EditText
                String textoIngresado = editText.getText().toString();

                // Mostrar el mensaje Toast
                Toast.makeText(MainActivity.this, textoIngresado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
