package com.example.depcure;

public class Nivel {

    private String codeName, alimentacion, medicament;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Nivel(String codeName, String alimentacion, String medicament) {
        this.codeName = codeName;
        this.alimentacion = alimentacion;
        this.medicament = medicament;
        this.expandable = false;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    @Override
    public String toString() {
        return "Nivel{" +
                "codeName='" + codeName + '\'' +
                ", alimentacion='" + alimentacion + '\'' +
                ", medicament='" + medicament + '\'' +
                '}';
    }
}
