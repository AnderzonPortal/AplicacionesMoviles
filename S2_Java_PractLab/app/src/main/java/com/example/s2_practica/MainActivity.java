package com.example.s2_practica;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Importaciones de las vistas
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencias a los elementos de la interfaz
        EditText valA = findViewById(R.id.valA);
        EditText valB = findViewById(R.id.valB);
        Button btnMul = findViewById(R.id.btnMul);
        TextView tvRes = findViewById(R.id.tvRes);

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = valA.getText().toString().trim();
                String b = valB.getText().toString().trim();
                if (!a.isEmpty() && !b.isEmpty()) {

                    double result = Double.parseDouble(a)* Double.parseDouble(b);
                    tvRes.setText("Resultado es:" +result);

                }


            }
        });
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}