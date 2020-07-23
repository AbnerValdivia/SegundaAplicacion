package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputEditText nombre;
    TextInputEditText fechat;
    String obtenerFecha;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;
    Button botonSiguiente;
    Intent intento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.etNombre);
        fechat = findViewById(R.id.etFecha);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etDescripcion);
        botonSiguiente = findViewById(R.id.botonSiguiente);

        botonSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validarDatos();
                if(validarDatos()){
                    String nombreStr= nombre.getEditableText().toString();
                    String fechaStr = fechat.getText().toString();
                    String telefonoStr = telefono.getText().toString();
                    String emailStr = email.getText().toString();
                    String descripcionStr = descripcion.getText().toString();

                    Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                    intent.putExtra("nombre",nombreStr);
                    intent.putExtra("fecha",fechaStr);
                    intent.putExtra("telefono",telefonoStr);
                    intent.putExtra("email",emailStr);
                    intent.putExtra("descripcion",descripcionStr);
                    startActivity(intent);
                }
            }
        });
    }

    public void showDatePickerDialog(View v) {
        pickerDialog recogerFecha = new pickerDialog().newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                final String cero = "0";
                final int mesActual = mes+1;
                String diaFormateado = (dia<10)?cero+String.valueOf(dia):String.valueOf(dia);
                String mesFormateado = (mes<10)?cero+String.valueOf(mes):String.valueOf(mes);
                final String fechaSeleccionada = diaFormateado+"/"+(mesFormateado)+"/"+anio;
                obtenerFecha = fechaSeleccionada;
                fechat.setText(fechaSeleccionada);
            }
        });
        recogerFecha.show(getSupportFragmentManager(), "datePicker");
    }

    boolean validarNombre(String nombrev){
        Pattern patron = Pattern.compile("[a-zA-Z ]+");
        if(!patron.matcher(nombrev).matches()){
            nombre.setError("Nombre inválido");
            return false;
        }else
            return true;
    }

    boolean validarTelefono(String telefonov){
        if(!Patterns.PHONE.matcher(telefonov).matches()){
            telefono.setError("Telefono inválido");
            return false;
        }else
            return true;
    }

    boolean validarEmail(String emailv){
        if(!Patterns.EMAIL_ADDRESS.matcher(emailv).matches()){
            email.setError("Email inválido");
            return false;
        }else
            return true;
    }

    public boolean validarDatos(){
     String nombrev = nombre.getEditableText().toString();
     String telefonov = telefono.getEditableText().toString();
     String emailv = email.getEditableText().toString();
     boolean nom = validarNombre(nombrev);
     boolean tel = validarTelefono(telefonov);
     boolean emai = validarEmail(emailv);
     if(nom && tel && emai){
         //Toast.makeText(this,"No hubo error",Toast.LENGTH_LONG).show();
         return true;
     }else
         //Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        return false;
    }

}
