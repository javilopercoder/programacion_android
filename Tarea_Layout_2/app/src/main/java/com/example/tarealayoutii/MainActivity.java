package com.example.tarealayoutii;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;  // Importar para mostrar el mensaje
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private boolean playerX = true; // true: jugador 1 (X), false: jugador 2 (O)
    private boolean gameEnded = false; // Para saber si el juego ha terminado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < 3; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = (Button) row.getChildAt(j);
                final int x = i, y = j;

                // Establecer el listener para el clic
                buttons[i][j].setOnClickListener(v -> onButtonClick(x, y));

                // Configuración del tamaño del texto
                buttons[i][j].setTextSize(40);
            }
        }

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> finish());
    }

    private void onButtonClick(int x, int y) {
        if (!gameEnded && buttons[x][y].getText().toString().equals("")) {
            // Establecer el texto del botón según el jugador
            buttons[x][y].setText(playerX ? "X" : "O");

            // Verificar si el jugador ha ganado
            if (checkWinner()) {
                String winner = playerX ? "Jugador 1 (X)" : "Jugador 2 (O)";
                Toast.makeText(this, winner + " ha ganado!", Toast.LENGTH_LONG).show();
                gameEnded = true;
                disableButtons(); // Deshabilitar los botones para evitar más clics
            }

            // Cambiar al siguiente jugador
            playerX = !playerX;
        }
    }

    private boolean checkWinner() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            // Verificar filas
            if (buttons[i][0].getText().toString().equals(buttons[i][1].getText().toString()) &&
                    buttons[i][1].getText().toString().equals(buttons[i][2].getText().toString()) &&
                    !buttons[i][0].getText().toString().equals("")) {
                return true;
            }
            // Verificar columnas
            if (buttons[0][i].getText().toString().equals(buttons[1][i].getText().toString()) &&
                    buttons[1][i].getText().toString().equals(buttons[2][i].getText().toString()) &&
                    !buttons[0][i].getText().toString().equals("")) {
                return true;
            }
        }

        // Verificar diagonales
        if (buttons[0][0].getText().toString().equals(buttons[1][1].getText().toString()) &&
                buttons[1][1].getText().toString().equals(buttons[2][2].getText().toString()) &&
                !buttons[0][0].getText().toString().equals("")) {
            return true;
        }
        if (buttons[0][2].getText().toString().equals(buttons[1][1].getText().toString()) &&
                buttons[1][1].getText().toString().equals(buttons[2][0].getText().toString()) &&
                !buttons[0][2].getText().toString().equals("")) {
            return true;
        }

        return false;
    }

    private void disableButtons() {
        // Deshabilitar todos los botones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
