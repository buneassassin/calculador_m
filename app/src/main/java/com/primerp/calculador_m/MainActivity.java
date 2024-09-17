package com.primerp.calculador_m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar el botón con su ID
        Button myButton = findViewById(R.id.button_7);

        // Asignar un listener al botón para manejar el evento onClick
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción que se ejecutará cuando se presione el botón
                Toast.makeText(MainActivity.this, "Botón presionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
