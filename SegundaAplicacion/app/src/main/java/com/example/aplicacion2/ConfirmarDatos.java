package com.example.aplicacion2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.channels.InterruptedByTimeoutException;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        TextView showNombre = findViewById(R.id.tvNombre);
        TextView showFecha = findViewById(R.id.tvFecha);
        TextView showTelefono = findViewById(R.id.tvTelefono);
        TextView showEmail = findViewById(R.id.tvEmail);
        TextView showDesc = findViewById(R.id.tvDesc);
        Button botonEditar = findViewById(R.id.botEditar);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String fecha = extras.getString("fecha");
        String telefono = extras.getString("telefono");
        String email = extras.getString("email");
        String descripcion = extras.getString("descripcion");

        showNombre.setText(nombre);
        showFecha.setText(fecha);
        showTelefono.setText(telefono);
        showEmail.setText(email);
        showDesc.setText(descripcion);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent intent = new Intent(ConfirmarDatos.this , MainActivity.class);
                startActivity(intent);
              */ onBackPressed();
            }
        });
    }

}
