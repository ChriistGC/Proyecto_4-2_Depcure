package com.example.depcure.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.depcure.fragments.CuestionarioFragment;
import com.example.depcure.fragments.PerfilFragment;
import com.example.depcure.fragments.PrincipalFragment;
import com.example.depcure.R;
import com.example.depcure.fragments.TratamientoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PrincipalpageActivity extends AppCompatActivity {

    //Declaramos los Fragmentos
    PrincipalFragment principalFragment = new PrincipalFragment();
    TratamientoFragment tratamientoFragment = new TratamientoFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    CuestionarioFragment cuestionarioFragment = new CuestionarioFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Referenciamos el BottomNavigation con su id
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedlistener);

        loadFragment(principalFragment);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.principalFragment:
                    loadFragment(principalFragment);
                    return true;
                case R.id.tratamientoFragment:
                    loadFragment(tratamientoFragment);
                    return true;
                case R.id.perfilFragment:
                    loadFragment(perfilFragment);
                    return true;
                case R.id.cuestionario:
                    loadFragment(cuestionarioFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
