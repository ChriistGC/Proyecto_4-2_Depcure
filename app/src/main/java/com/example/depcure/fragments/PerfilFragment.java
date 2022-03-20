package com.example.depcure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.depcure.R;

public class PerfilFragment extends Fragment {

    View vista;
    Button btnEditar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_perfil, container, false);


        btnEditar = vista.findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new EditarPerfilFragment();
                FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.frame_container, secondFrag).commit();
            }
        });

        return vista;
    }

}