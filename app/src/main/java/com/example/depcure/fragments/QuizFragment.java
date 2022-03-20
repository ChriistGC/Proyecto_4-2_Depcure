package com.example.depcure.fragments;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.depcure.Common.saveData;
import com.example.depcure.QuestionModel;
import com.example.depcure.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment{
    View vista;
    CountDownTimer countDownTimer;
    int timerValue = 10;
    Context thiscontext;
    ProgressBar progressBar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
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
    TextView question, noIndicador;
    FloatingActionButton bookmarketbtn;
    LinearLayout opcionContainer;
    Button nextbtn;
    private int count = 0, posicion = 0, score = 0, datoArreglo = 0;
    private ArrayList<QuestionModel> list;
    private QuestionModel Qmodel;
    FirebaseFirestore firebasedb = FirebaseFirestore.getInstance();//Acceso a la base de datos por medio de la instancia
    CollectionReference notesCollectionRef = firebasedb.collection("depc-Datadepresion");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Qmodel = new QuestionModel();
        vista = inflater.inflate(R.layout.fragment_quiz, container, false);
        question = vista.findViewById(R.id.Card_question);
        bookmarketbtn = vista.findViewById(R.id.floatingActionButton);
        nextbtn = vista.findViewById(R.id.btn_siguiente);
        opcionContainer = vista.findViewById(R.id.opcion_container);
        list = new ArrayList<>();
        list.add(new QuestionModel("1 ","Ausente ","Estas sensaciones las expresa solamente si le preguntan como se siente","Estas sensaciones las relata espontáneamente","Sensaciones no comunicadas verbalmente","Manifiesta estas sensaciones en su comunicación verbal y no verbal en forma\n" +
                "espontánea ","Ausente"));
        list.add(new QuestionModel("Tiene sentimientos de culpa? ","Ausente","Se culpa a si mismo, cree haber decepcionado a la gente","Tiene ideas de culpabilidad o medita sobre errores pasados o malas acciones ","Siente que la enfermedad actual es un castigo ","4","Oye voces acusatorias o de denuncia y/o experimenta alucinaciones visuales de amenaza"));
        list.add(new QuestionModel("Tiene sentimientos de suicidio","Ausente","Le parece que la vida no vale la pena ser vivida","Desea estar muerto","Tengo ideas de sucidio","Intente suicidarme","1"));
        list.add(new QuestionModel("Insomnio precoz","No tiene dificultad","Dificultad ocacional para dormir","Dificultad para dormir cada noche","N/A","N/A","1"));
        list.add(new QuestionModel("Insomnio intermedio","No hay dificultad","Esta desvelado e inquieto o se despierta varias veces durante la noche","Esta despierto durante la noche, cualquier ocacion de levantarse","N/A","N/A","1"));
        list.add(new QuestionModel("Insonmnio tardio","No hay dificultad","Se despierta a primeras horas de la madrugada, pero se vuelve al a dormir","No puede volver a dormirse si se levanta de la clama","N/A","N/A","1"));
        list.add(new QuestionModel("Trabajo y actividades","No hay dificultad","Ideas y sentimientos de incapacidad, fatiga o debilidad","Perdida de interes en su actividad","Disminucion del tiempo actual dedicado a actividades o disminucion de la productividad","Dejo de trabajar por la presente enfermedad","1"));
        list.add(new QuestionModel("Lentitud de pensamiento y lenguaje","Palabra y pensamiento normales","Ligero retraso en el habla","Dificultad para expresarse","Incapacidad para expresarse","Evidente retraso en el habla","1"));
        list.add(new QuestionModel("Agitacion psicomotora","Ninguna","Juega con sus dedos","Juega con sus manos, cabello","No puede quedarse quieto ni permanecer sentado","Retuerce las manos, se muerde las uñsa, se tira de los cabellos, se muerde los labios","1"));
        list.add(new QuestionModel("Ansiedad psiquica","No hay dificultad","Tension subjetiva e irritabilidad","Preocupacion por pequeñas cosas","Actitud aprensiva en la expresion o en el habla","Expresa sus temores sin que le pregunten","1"));
        list.add(new QuestionModel("Signos fisicos de ansiedad","Ausente","Ligera","Moderada","Severa","Incapacitante","1"));
        list.add(new QuestionModel("Sintomas somaticos gastrointestinales","Ninguno","Perdida del apetito pero come sin necesidad de que lo estimulen","Dificultad en comer si no se le insiste","Debe estinularlo constantemente para que acceda a comer","Se niega a comer determinadamente","1"));
        list.add(new QuestionModel("Sintomas somaticos generales","Ninguno","Pesades en las extremidades","Perdida de energia ","Fatigabilidad","Pesades en la espalda o en la cabeza","1"));
        list.add(new QuestionModel("Hipoondria","Ausente","Preocupado de si mismo","Preocupado por su salud","Se lamenta constantemente","Necesita ayuda inmediata","1"));
        list.add(new QuestionModel("Sintomas genitales","Ausente","Debil","en algunas ocaciones ","Medio","Grave","1"));
        list.add(new QuestionModel("Perdida de peso","inferior a 500 gr","mas de 500 gr","perdida hasta 1 kg en una semana","perdida de mas de 1 kg en una semana","Perdida superrioz","1"));
        Qmodel.setList(list);
        for (int i = 0; i < 5; i++){
            opcionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer((Button)view);
                }
            });
        }
        playAnim(question,0, list.get(posicion).getQuestion());
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(false);
                nextbtn.setAlpha(0.7f);
                enableOpcion(true);
                posicion++;
                if (posicion == list.size()){
                    return;
                }
                count = 0;
                playAnim(question,0, list.get(posicion).getQuestion());
            }
        });
        return vista;
    }
    private void playAnim(View view, int value, String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
        .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                if(value == 0 && count < 5){
                    String opcion =" ";
                    if(count == 0){
                        opcion = list.get(posicion).getOpcion1();
                    }else if(count == 1){
                        opcion = list.get(posicion).getOpcion2();
                    }else if(count == 2){
                        opcion = list.get(posicion).getOpcion3();
                    }else if(count == 3){
                        opcion = list.get(posicion).getOpcion4();
                    }else if(count == 4){
                        opcion = list.get(posicion).getOpcion5();
                    }
                    playAnim(opcionContainer.getChildAt(count), 0,opcion);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                //Cambio de dato
                if(value == 0){
                    try {
                        ((TextView)view).setText(data);

                    }catch (ClassCastException ex){
                            ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    playAnim(view, 1,data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    private void checkAnswer(Button selectedOpcion){
        enableOpcion(false);
        nextbtn.setEnabled(true);
        nextbtn.setAlpha(1);

        //this.datoArreglo = numQ;
        String res = selectedOpcion.getText().toString();
        //String numeroPregunta = String.valueOf(numQ);//Prueba para ver si esta sumando el numero de preguntas
        if(true){
            //correct
            score++;
            String numeroPregunta = String.valueOf(numQ);

            saveQuiz(res);
            numQ++;


            selectedOpcion.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
        }
    }
    int numQ = 1;
    private void enableOpcion(boolean enable){
        //aqui muestra la respuesta
        for (int i = 0; i < 5; i++){
            opcionContainer.getChildAt(i).setEnabled(enable);
            if(enable){
                opcionContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));

            }
        }
    }

    saveData save = new saveData();
    private void saveQuiz(String res){
        String promedio;
        if(numQ == 1){
            save.setRes1(res);
            Log.d("error","Q1");
        }else if(numQ == 2){
            save.setRes2(res);
            Log.d("error","Q2");
        }else if(numQ == 3){
            save.setRes3(res);
            Log.d("error","Q3");
        }else if(numQ == 4){
            save.setRes4(res);
            Log.d("error","Q4");
        }else if(numQ == 5){
            save.setRes5(res);
            Log.d("error","Q5");
        }else if(numQ == 6){
            save.setRes6(res);
            Log.d("error","Q6");
        }else if(numQ == 7){
            save.setRes7(res);
            Log.d("error","Q7");
        }else if(numQ == 8){
            save.setRes8(res);
            Log.d("error","Q8");
        }else if(numQ == 9){
            save.setRes9(res);
            Log.d("error","Q9");
        }else if(numQ == 10){
            save.setRes10(res);
            Log.d("error","Q10");
        }else if(numQ == 11){
            save.setRes11(res);
            Log.d("error","Q11");
        }else if(numQ == 12){
            save.setRes12(res);
            Log.d("error","Q12");
        }else if(numQ == 13){
            save.setRes13(res);
            Log.d("error","Q13");
        }else if(numQ == 14){
            save.setRes14(res);
            Log.d("error","Q14");
        }else if(numQ == 15){
            save.setRes15(res);
            Log.d("error","Q15");
        }else if(numQ == 16){
            save.setRes16(res);
            Log.d("error","Q16");
            //promedio = String.valueOf(Qmodel.getRes());
            //Log.d("error",promedio);
            save.setCed("0952548543");

            Create();
        }
    }

    private void Create(){
        firebasedb.collection("depc-Datadepresion")//Nombre referencia de la coleccion
                .document("0954141008")//Crea un documento cuyo id es la cedula
                .set(save)//envio la isntancia de persona
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

}