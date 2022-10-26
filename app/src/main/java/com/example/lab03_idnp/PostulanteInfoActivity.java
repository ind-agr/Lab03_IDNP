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
    private static final String TAG = "PostulanteInforAntivity";
    Button btnSearch;
    TextView name;
    TextView lastnameP;
    TextView lastnameM;
    TextView dni;
    TextView date;
    TextView school;
    TextView major;

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
                Bundle args = intent.getBundleExtra("BUNDLE");
                ArrayList<Postulante> postulanteList = (ArrayList<Postulante>) args.getSerializable("list");

                for(Postulante a : postulanteList){
                    if(strDNI.equals(a.getDni())){
                        String datName = intent.getStringExtra(a.getNombre());
                        String datApePat = intent.getStringExtra(a.getApellidoPaterno());
                        String datApeMat = intent.getStringExtra(a.getApellidoMaterno());
                        String datDni = intent.getStringExtra(a.getDni());
                        String datFechaNacimiento = intent.getStringExtra(a.getFechaNac());
                        String datColegio = intent.getStringExtra(a.getColegio());
                        String datCarrera = intent.getStringExtra(a.getCarrera());

                        name = findViewById(R.id.edt2Name);
                        lastnameP = findViewById(R.id.edt2ApePat);
                        lastnameM = findViewById(R.id.edt2ApeMat);
                        dni = findViewById(R.id.edt2DNI);
                        date = findViewById(R.id.edt2FecNac);
                        school = findViewById(R.id.edt2Colegio);
                        major = findViewById(R.id.edt2Carrera);

                        name.setText(datName);
                        lastnameP.setText(datApePat);
                        lastnameM.setText(datApeMat);
                        dni.setText(datDni);
                        date.setText(datFechaNacimiento);
                        school.setText(datColegio);
                        major.setText(datCarrera);
                        Log.d(TAG,"there is");
                    }
                    else {
                        Toast.makeText(PostulanteInfoActivity.this,"Error :(",Toast.LENGTH_SHORT).show();
                        Log.d(TAG,"no hay");
                    }
                }
            }
        });


    }
}