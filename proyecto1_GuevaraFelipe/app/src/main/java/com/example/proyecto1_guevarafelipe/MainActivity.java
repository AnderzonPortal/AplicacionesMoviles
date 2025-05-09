package com.example.proyecto1_guevarafelipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaración de variables
    private TextView tvCounter;
    private Button btnIncrement, btnReset, btnDecrementar;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cargar el layout activity_main.xml
        setContentView(R.layout.activity_main);

        // Referenciar las vistas correctamente
        tvCounter = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnReset = findViewById(R.id.btnReset);
        btnDecrementar = findViewById(R.id.btnDecrementar);

        // Listener para el botón Incrementar
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarContador();
            }
        });

        // Listener para el botón Reiniciar
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarContador();
            }
        });

        // Listener para el botón Decrementar
        btnDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContador();
            }
        });
    }

    // Función para aumentar contador
    private void aumentarContador() {
        cont++;
        tvCounter.setText("Contador: " + cont);
    }

    // Función para reiniciar contador
    private void reiniciarContador() {
        cont = 0;
        tvCounter.setText("Contador: " + cont);
    }

    private void decrementarContador() {
        if (cont > 0) {
            cont--;
        }
        tvCounter.setText("Contador: " + cont);
    }

}
