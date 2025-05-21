package com.example.s1_loginregister;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText txtNombre, txtEmail, txtTelefono, txtUsuario, txtClave;
    Button btnRegistrar;
    TextView lblIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNombre = findViewById(R.id.txtnomapellidos);
        txtEmail = findViewById(R.id.txtemail);
        txtTelefono = findViewById(R.id.txttelefono);
        txtUsuario = findViewById(R.id.txtusuario);
        txtClave = findViewById(R.id.txtclave);
        btnRegistrar = findViewById(R.id.btnregistrar);
        lblIniciarSesion = findViewById(R.id.lbliniciarsesion);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        lblIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver al login
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String telefono = txtTelefono.getText().toString().trim();
        String usuario = txtUsuario.getText().toString().trim();
        String clave = txtClave.getText().toString().trim();

        if (usuario.isEmpty() || clave.isEmpty()) {
            Toast.makeText(this, "Usuario y clave son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("usuario", usuario);
        values.put("clave", clave);

        long id = db.insert("usuarios", null, values);
        db.close();

        if (id != -1) {
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
        }
    }
}
