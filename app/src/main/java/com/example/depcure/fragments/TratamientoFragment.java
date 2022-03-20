package com.example.depcure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.depcure.Nivel;
import com.example.depcure.NivelAdapter;
import com.example.depcure.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TratamientoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TratamientoFragment extends Fragment {

    RecyclerView recyclerView;
    List<Nivel> nivelList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TratamientoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TratamientoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TratamientoFragment newInstance(String param1, String param2) {
        TratamientoFragment fragment = new TratamientoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_tratamiento, container, false);
        recyclerView = vista.findViewById(R.id.recyclerView);

        initData();
        setRecyclerView();
        return vista;
    }

    private void setRecyclerView() {
        NivelAdapter nivelAdapter = new NivelAdapter(nivelList);
        recyclerView.setAdapter(nivelAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        nivelList = new ArrayList<>();

        nivelList.add(new Nivel("NIVEL 1", "Desayuno: Manzana y Agua \n\nAlmuerzo: Carne Blanca y Ensalada \n\nCena: Pan integral y Jugo", "Fluoxetine (fluoxetina) cada 6 horas"));
        nivelList.add(new Nivel("NIVEL 2", "Desayuno: Pera y Jugo \n\nAlmuerzo: Pescado Azul y Ensalada \n\nCena: Ensalada de verduras al vapor", "Fluoxetine (fluoxetina) cada 6 horas \n\nCitalopram cada 7 horas"));
        nivelList.add(new Nivel("NIVEL 3", "Desayuno: Cereal y Leche \n\nAlmuerzo: Verduras y Carne Blanca \n\nCena: Nueces", "Sertraline (sertralina) cada 8 horas \n\nCitalopram cada 10 horas"));
        nivelList.add(new Nivel("NIVEL 4", "Desayuno: Piña y Agua \n\nAlmuerzo: Pollo Asado y Verduras \n\nCena: Semillas de Ajonjolí", "Paroxetine (paroxetina) cada 10 horas \n\nEscitalopram cada 8 horas"));
        nivelList.add(new Nivel("NIVEL 5", "Desayuno: Avena \n\nAlmuerzo: Verduras y Carne Blanca \n\nCena: Sopa de Arroz", "Mirtazapine cada 7 horas \n\nFluoxetine (fluoxetina) cada 6 horas"));
        nivelList.add(new Nivel("NIVEL 6", "Desayuno: Cereal y Yogur \n\nAlmuerzo: Arroz Integral y Pollo Asado \n\nCena: Té verde", "Fluvoxamina cada 8 horas \n\nMirtazapine cada 7 horas"));
    }
}