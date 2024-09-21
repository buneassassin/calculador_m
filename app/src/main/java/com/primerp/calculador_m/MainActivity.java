package com.primerp.calculador_m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override  //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar el botón con su ID
        Button myButton =(Button) findViewById(R.id.button_7);
        // Asignar un listener al botón para manejar el evento onClick
        myButton.setOnClickListener(this);
    }

    public void onButtonClick(View view) {

    }
    // encadenamiento boton , chein
    // login imagen (lottie file) linias guias y contraint
    // diseño tipica de aplicacion linias guia con 150dp contraintlayaut abajo tres botones con ecadenamiento uno con otro centrado con paqui y ariba con el titulo de la palicacion con linerleyaut anclado y otro linerleyaut

    @Override
    public void onClick(View view) {



    }
}
