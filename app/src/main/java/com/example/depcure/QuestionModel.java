package com.example.depcure;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class QuestionModel {
    private String question , opcion1,opcion2,opcion3,opcion4,opcion5,res_correct;
    private int res;
    private ArrayList<QuestionModel> list;
    private ArrayList<QuestionModel> listSave;
    String[] datos = new String[6];

    public ArrayList<QuestionModel> getListSave() {
        return listSave;
    }

    public void setListSave(ArrayList<QuestionModel> listSave) {
        this.listSave = listSave;
    }

    public ArrayList<QuestionModel> getList() {
        return list;
    }

    public void setList(ArrayList<QuestionModel> list) {
        this.list = list;
    }

    public QuestionModel() {
    }

    public QuestionModel(String question, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5, String res_correct) {
        this.question = question;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
        this.res_correct = res_correct;
    }

    public QuestionModel(String question, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5, String res_correct, ArrayList<QuestionModel> list, ArrayList<QuestionModel> listSave) {
        this.question = question;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
        this.res_correct = res_correct;
        this.list = list;
        this.listSave = listSave;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    public String getRes_correct() {
        return res_correct;
    }

    public void setRes_correct(String res_correct) {
        this.res_correct = res_correct;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = this.res + res ;
    }

    public void busqueda(String busqueda,int pos ){
        datos[0] = list.get(pos).getQuestion();
        datos[1] = list.get(pos).getOpcion1();
        datos[2] = list.get(pos).getOpcion2();
        datos[3] = list.get(pos).getOpcion3();
        datos[4] = list.get(pos).getOpcion4();
        datos[5] = list.get(pos).getOpcion5();
        busquedaPart2(busqueda);
        System.out.println(this.getRes());
        datos[0] = " ";
        datos[1] = " ";
        datos[2] = " ";
        datos[3] = " ";
        datos[4] = " ";
        datos[5] = " ";
    }
    public void busquedaPart2(String busqueda){
        for(int i = 0; i < 6; i++){
            System.out.println(datos[i]);
            if(datos[i] == busqueda){
                this.setRes(i-1);
            }
        }
    }
}