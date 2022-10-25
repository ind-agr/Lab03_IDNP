package com.example.lab03_idnp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    Button btnRegNew;
    private List<Postulante> postulanteList = new ArrayList<>();
    Postulante postul = new Postulante();

    ActivityResultLauncher<Intent>launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == 11){
                Intent intent = result.getData();
                if(intent != null){
                    String dataName = intent.getStringExtra("nombre");
                    String dataApePat = intent.getStringExtra("apellidoPaterno");
                    String dataApeMat = intent.getStringExtra("apellidoMaterno");
                    String dataDni = intent.getStringExtra("dni");
                    String dataFechaNacimiento = intent.getStringExtra("fechaNacimiento");
                    String dataColegio = intent.getStringExtra("colegio");
                    String dataCarrera = intent.getStringExtra("carrera");
                    postul.setNombre(dataName);
                    postul.setApellidoPaterno(dataApePat);
                    postul.setApellidoMaterno(dataApeMat);
                    postul.setDni(dataDni);
                    postul.setFechaNac(dataFechaNacimiento);
                    postul.setColegio(dataColegio);
                    postul.setCarrera(dataCarrera);
                    postulanteList.add(postul);
                    Toast.makeText(MenuActivity.this,"OK",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MenuActivity.this,"Error :(",Toast.LENGTH_SHORT).show();
            }

        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnRegNew = findViewById(R.id.btnNuevo);


        btnRegNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistro = new Intent(MenuActivity.this,PostulanteRegistroActivity.class);
                launcher.launch(intentRegistro);

            }
        });
    }
}