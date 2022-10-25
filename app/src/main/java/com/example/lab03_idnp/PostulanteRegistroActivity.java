package com.example.lab03_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostulanteRegistroActivity extends AppCompatActivity {
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        EditText edtNombres = findViewById(R.id.edtName);
        EditText edtApellidoPaterno = findViewById(R.id.edtApePat);
        EditText edtApellidoMaterno = findViewById(R.id.edtApeMat);
        EditText edtDni = findViewById(R.id.edtDni);
        EditText edtFechaNacimiento = findViewById(R.id.edtFecNac);
        EditText edtColegioPrecedencia = findViewById(R.id.edtCole);
        EditText edtCarrera = findViewById(R.id.edtCar);
        btnRegistrar =findViewById(R.id.btnRegister);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("nombre",edtNombres.getText().toString());
                intent.putExtra("apellidoPaterno", edtApellidoPaterno.getText().toString());
                intent.putExtra("apellidoMaterno", edtApellidoMaterno.getText().toString());
                intent.putExtra("dni", edtDni.getText().toString());
                intent.putExtra("fechaNacimiento", edtFechaNacimiento.getText().toString());
                intent.putExtra("colegio", edtColegioPrecedencia.getText().toString());
                intent.putExtra("carrera", edtCarrera.getText().toString());
                setResult(11,intent);
                finish();
            }
        });


    }
}