package com.example.lab03_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostulanteInfoActivity extends AppCompatActivity {
    Button btnSearch;
    TextView name = findViewById(R.id.edt2Name);
    TextView lastnameP= findViewById(R.id.edt2ApePat);
    TextView lastnameM= findViewById(R.id.edt2ApeMat);
    TextView dni= findViewById(R.id.edt2DNI);
    TextView date= findViewById(R.id.edt2FecNac);
    TextView school= findViewById(R.id.edt2Colegio);
    TextView major= findViewById(R.id.edt2Carrera);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        EditText edtDNI = findViewById(R.id.searchDNI);
        btnSearch = findViewById(R.id.btnBuscar);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strDNI = edtDNI.getText().toString();

                Intent intent = getIntent();
                Bundle args = new Bundle();
                ArrayList<Postulante> postulanteList = (ArrayList<Postulante>) args.getSerializable("list");
                for(Postulante a : postulanteList){
                    if(strDNI.equals(a.getDni())){
                        String datName = a.getNombre();
                        String datApePat = a.getApellidoPaterno();
                        String datApeMat = a.getApellidoMaterno();
                        String datDni = a.getDni();
                        String datFechaNacimiento = a.getFechaNac();
                        String datColegio = a.getColegio();
                        String datCarrera = a.getCarrera();



                        name.setText(datName);
                        lastnameP.setText(datApePat);
                        lastnameM.setText(datApeMat);
                        dni.setText(datDni);
                        date.setText(datFechaNacimiento);
                        school.setText(datColegio);
                        major.setText(datCarrera);
                    }
                    else {
                        Toast.makeText(PostulanteInfoActivity.this,"Error :(",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}