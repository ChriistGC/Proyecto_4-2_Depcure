package com.example.depcure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.depcure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity{

    private FirebaseAuth nAuth;
    private DatabaseReference nDatabase;
    private EditText editNom, editCed, editEd, editTel, editCorr, editCon;
    private Button registrar;
    //private ProgressBar progressBar;
    private String nom, ced, ed, tel, corr, con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nAuth = FirebaseAuth.getInstance();
        nDatabase = FirebaseDatabase.getInstance().getReference();

        registrar = (Button) findViewById(R.id.btn_regis);

        editNom = (EditText) findViewById(R.id.editNombre);
        editCed = (EditText) findViewById(R.id.editCedula);
        editEd = (EditText) findViewById(R.id.editEdad);
        editTel = (EditText) findViewById(R.id.editTelefono);
        editCorr = (EditText) findViewById(R.id.editCorre);
        editCon = (EditText) findViewById(R.id.editContras);

        //progressBar = (ProgressBar) findViewById(R.id.progbar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = editNom.getText().toString();
                ced = editCed.getText().toString();
                ed = editEd.getText().toString();
                tel = editTel.getText().toString();
                corr = editCorr.getText().toString();
                con = editCon.getText().toString();

                if (!nom.isEmpty() && !ced.isEmpty() && !ed.isEmpty() && !tel.isEmpty() &&
                        !corr.isEmpty() && !con.isEmpty()){
                    if (con.length()>=6){
                        regis_users();
                        Toast.makeText(RegisterActivity.this, "Se ha registrado correctamente",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "La contraseña debe ser mayor a 6 dígitos",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Debe completar los campos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void regis_users(){
        nAuth.createUserWithEmailAndPassword(corr,con).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre:",nom);
                    map.put("Cédula:", ced);
                    map.put("Edad", ed);
                    map.put("Teléfono:",tel);
                    map.put("Correo:", corr);
                    map.put("Contraseña", con);

                    String id = nAuth.getCurrentUser().getUid();

                    nDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener
                            (new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                    if (task2.isSuccessful()){
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(RegisterActivity.this,"No se pudo crear el usuario",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "No se pudo registrar este usuario",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
