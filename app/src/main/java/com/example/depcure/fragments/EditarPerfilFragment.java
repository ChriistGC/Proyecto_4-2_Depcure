package com.example.depcure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.depcure.R;

public class EditarPerfilFragment extends Fragment {

    View vista;
    Button btnActualizar;
    Button btnCancelar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        btnActualizar = vista.findViewById(R.id.btnActualizar);
        btnCancelar = vista.findViewById(R.id.btnCancelar);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Perfil Actualizado",Toast.LENGTH_SHORT).show();
                Fragment secondFrag = new PerfilFragment();
                FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.frame_container, secondFrag).commit();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Cancelado",Toast.LENGTH_SHORT).show();
                Fragment secondFrag = new PerfilFragment();
                FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.frame_container, secondFrag).commit();
            }
        });

        return vista;
    }
}