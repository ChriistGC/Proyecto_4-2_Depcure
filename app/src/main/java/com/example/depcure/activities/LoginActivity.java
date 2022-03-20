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

public class LoginActivity extends AppCompatActivity {

    private EditText editCor, editCont;
    private Button ingresar;
    private FirebaseAuth mAuthd;
    private String corre,cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuthd = FirebaseAuth.getInstance();

        editCor = (EditText) findViewById(R.id.editCorreo);
        editCont = (EditText) findViewById(R.id.editContra);

        ingresar = (Button) findViewById(R.id.btn_log);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corre = editCor.getText().toString();
                cont = editCont.getText().toString();

                if (!corre.isEmpty() && !cont.isEmpty()){
                    login_users();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Debe completar los campos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login_users(){
        mAuthd.signInWithEmailAndPassword(corre,cont).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Ingreso exitóso",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, PrincipalpageActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "No se pudo iniciar sesión, compruebe los datos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
