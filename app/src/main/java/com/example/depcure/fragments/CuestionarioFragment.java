package com.example.depcure.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.depcure.R;

import java.util.Timer;
import java.util.TimerTask;

public class CuestionarioFragment extends Fragment  {
    ProgressBar progressBar;
    Handler handler = new Handler();
    boolean isActivo = false;
    int counter = 0;
    Intent x;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test,container,false);
        progressBar = root.findViewById(R.id.progressbar);
        timeProgressBar();
        return root;
    }
    //Imprementación del método
    public void timeProgressBar(){
        final Timer t = new Timer();
        counter=0;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if(counter==50){
                    Fragment qf = new QuizFragment(); //Crea una nueva instancia de fragmento igualandola a QuizFragment()
                    FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                    fn.replace(R.id.frame_container, qf).commit();//Presentacion y comiteo donde se llama al nuevo contenedor

                }

            }
        };
        t.schedule(tt,0,50);//Inicio del contador de 0 a 100 en donde se presentara la clase
    }

}
