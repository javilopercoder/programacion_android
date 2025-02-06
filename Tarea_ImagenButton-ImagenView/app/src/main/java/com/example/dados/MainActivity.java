package com.example.dados;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButtonCubo;
    private ImageView imageViewDado1, imageViewDado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonCubo = findViewById(R.id.imageButtonCubo);
        imageViewDado1 = findViewById(R.id.imageViewDado1);
        imageViewDado2 = findViewById(R.id.imageViewDado2);

        imageButtonCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarDados();
            }
        });
    }

    private void cambiarDados() {
        Random random = new Random();

        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;


        imageViewDado1.setImageResource(getDadoResource(dado1));
        imageViewDado2.setImageResource(getDadoResource(dado2));

        if (dado1 == dado2) {
            Toast.makeText(MainActivity.this, "¡Los dados son iguales! Tira otra vez.", Toast.LENGTH_SHORT).show();
        }
    }

    private int getDadoResource(int dado) {
        switch (dado) {
            case 1:
                return R.drawable.dice_1;
            case 2:
                return R.drawable.dice_2;
            case 3:
                return R.drawable.dice_3;
            case 4:
                return R.drawable.dice_4;
            case 5:
                return R.drawable.dice_5;
            case 6:
                return R.drawable.dice_6;
            default:
                return R.drawable.dice_1; // Default case (aunque no debería pasar)
        }
    }
}
