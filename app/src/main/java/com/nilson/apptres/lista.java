package com.nilson.apptres;

public class lista {



    String fechafinal;
    String fechainicial;
    String alarma;

    String nmedicamento;

    public lista(String fechafinal, String fechainicial, String alarma, String nmedicamento) {
        this.fechafinal = fechafinal;
        this.fechainicial = fechainicial;
        this.alarma = alarma;
        this.nmedicamento = nmedicamento;
    }

    public String getNmedicamento() {
        return nmedicamento;
    }

    public void setNmedicamento(String nmedicamento) {
        this.nmedicamento = nmedicamento;
    }

    public lista(String fechafinal, String fechainicial, String alarma) {
        this.fechafinal = fechafinal;
        this.fechainicial = fechainicial;
        this.alarma = alarma;

    }



    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(String fechainicial) {
        this.fechainicial = fechainicial;
    }

    public String getAlarma() {
        return alarma;
    }

    public void setAlarma(String alarma) {
        this.alarma = alarma;
    }
}
