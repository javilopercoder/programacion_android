package com.example.tareaspinner;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private Spinner spinner;
    private Button btnCalcular;
    private TextView tvResultado;
    private String operacionSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        spinner = findViewById(R.id.spinner);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        // Opciones del Spinner
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner.setAdapter(adapter);

        // Manejar selección del Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operacionSeleccionada = opciones[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                operacionSeleccionada = "Sumar"; // Valor por defecto
            }
        });

        // Botón de cálculo
        btnCalcular.setOnClickListener(v -> {
            if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
                double numero1 = Double.parseDouble(num1.getText().toString());
                double numero2 = Double.parseDouble(num2.getText().toString());
                double resultado = 0;

                switch (operacionSeleccionada) {
                    case "Sumar":
                        resultado = numero1 + numero2;
                        break;
                    case "Restar":
                        resultado = numero1 - numero2;
                        break;
                    case "Multiplicar":
                        resultado = numero1 * numero2;
                        break;
                    case "Dividir":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            tvResultado.setText("Error: División por 0");
                            return;
                        }
                        break;
                }

                tvResultado.setText("El resultado es: " + resultado);
            } else {
                tvResultado.setText("Por favor, ingrese ambos números");
            }
        });
    }
}
