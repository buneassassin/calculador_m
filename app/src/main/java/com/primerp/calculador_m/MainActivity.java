package com.primerp.calculador_m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    private TextView display;
    private double primerNumero = 0;
    private double segundoNumero = 0;
    private String operacion = "";
    private boolean nuevoNumero = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        configurarBotonesNumericos();
        configurarBotonesOperaciones();
    }

    // Configura los botones numéricos (0-9) y el punto decimal
    private void configurarBotonesNumericos() {
        int[] botonesNumericos = {
                R.id.button_0, R.id.button_1, R.id.button_2,
                R.id.button_3, R.id.button_4, R.id.button_5,
                R.id.button_6, R.id.button_7, R.id.button_8,
                R.id.button_9, R.id.button_coma
        };

        View.OnClickListener listenerNumerico = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                String textoBoton = boton.getText().toString();

                if (nuevoNumero) {
                    display.setText(textoBoton);
                    nuevoNumero = false;
                } else {
                    display.append(textoBoton);
                }
            }
        };

        for (int id : botonesNumericos) {
            findViewById(id).setOnClickListener(listenerNumerico);
        }
    }

    // Configura los botones de las operaciones (+, -, *, /)
    private void configurarBotonesOperaciones() {
        int[] botonesOperaciones = {
                R.id.button_mas, R.id.button_menos,
                R.id.button_multi, R.id.button_divide
        };

        View.OnClickListener listenerOperacion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                operacion = boton.getText().toString();
                primerNumero = Double.parseDouble(display.getText().toString());
                nuevoNumero = true;
            }
        };

        for (int id : botonesOperaciones) {
            findViewById(id).setOnClickListener(listenerOperacion);
        }

        // Configurar el botón "=" para realizar el cálculo
        findViewById(R.id.button_igual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segundoNumero = Double.parseDouble(display.getText().toString());
                double resultado = realizarOperacion(primerNumero, segundoNumero, operacion);
                display.setText(String.valueOf(resultado));
                nuevoNumero = true;
            }
        });

        // Configurar el botón "C" para borrar
        findViewById(R.id.button_C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
                primerNumero = 0;
                segundoNumero = 0;
                operacion = "";
                nuevoNumero = true;
            }
        });
    }

    // Realiza la operación aritmética basada en la entrada
    private double realizarOperacion(double num1, double num2, String operacion) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    display.setText("Error"); // Error por división entre 0
                    return 0;
                }
            default:
                return 0;
        }
    }
}
