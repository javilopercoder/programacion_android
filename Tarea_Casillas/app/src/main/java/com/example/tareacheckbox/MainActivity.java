package com.example.tareacheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    RadioGroup radioGroupOperations;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        radioGroupOperations = findViewById(R.id.radioGroupOperations);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los números ingresados
                String num1Str = editTextNumber1.getText().toString();
                String num2Str = editTextNumber2.getText().toString();

                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa ambos números.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                // Obtener la operación seleccionada
                int selectedOperationId = radioGroupOperations.getCheckedRadioButtonId();
                double result = 0;

                // Usar if-else en lugar de switch
                if (selectedOperationId == R.id.radioButtonSum) {
                    result = num1 + num2;
                } else if (selectedOperationId == R.id.radioButtonSubtract) {
                    result = num1 - num2;
                } else if (selectedOperationId == R.id.radioButtonMultiply) {
                    result = num1 * num2;
                } else if (selectedOperationId == R.id.radioButtonDivide) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(MainActivity.this, "No se puede dividir por 0.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, selecciona una operación.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mostrar el resultado
                textViewResult.setText("El resultado es: " + result);
            }
        });
    }
}
