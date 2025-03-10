package com.example.intentactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2;
    private ListView operationsList;
    private Button showResultButton;
    private String selectedOperation = "Suma"; // Operación por defecto
    private int selectedPosition = -1; // Posición seleccionada en el ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        operationsList = findViewById(R.id.operationsList);
        showResultButton = findViewById(R.id.showResultButton);

        // Lista de operaciones
        String[] operations = {"Suma", "Resta", "Multiplicación", "División"};

        // Adaptador personalizado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_operation, R.id.operationText, operations) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                // Cambiar el color del ítem seleccionado
                if (position == selectedPosition) {
                    view.setBackgroundColor(Color.LTGRAY); // Color de fondo seleccionado
                    ((TextView) view.findViewById(R.id.operationText)).setTextColor(Color.BLUE); // Color de texto seleccionado
                } else {
                    view.setBackgroundColor(Color.WHITE); // Color de fondo por defecto
                    ((TextView) view.findViewById(R.id.operationText)).setTextColor(Color.BLACK); // Color de texto por defecto
                }

                return view;
            }
        };

        operationsList.setAdapter(adapter);

        // Seleccionar operación
        operationsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOperation = operations[position];
                selectedPosition = position; // Guardar la posición seleccionada
                adapter.notifyDataSetChanged(); // Actualizar el ListView
            }
        });

        // Botón para mostrar datos en ResultActivity
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                double result = calculateResult(num1, num2, selectedOperation);

                // Crear Intent para abrir ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("NUMBER1", num1);
                intent.putExtra("NUMBER2", num2);
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }
        });
    }

    // Método para calcular el resultado
    private double calculateResult(double num1, double num2, String operation) {
        switch (operation) {
            case "Suma":
                return num1 + num2;
            case "Resta":
                return num1 - num2;
            case "Multiplicación":
                return num1 * num2;
            case "División":
                return num1 / num2;
            default:
                return 0;
        }
    }
}