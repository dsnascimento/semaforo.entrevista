package com.semaforo.api.trafego.model;

public class TempoSemaforoResponse {
    private double tempoSemaforo;

    public TempoSemaforoResponse(double tempoSemaforo) {
        this.tempoSemaforo = tempoSemaforo;
    }

    public double getTempoSemaforo() {
        return tempoSemaforo;
    }

    public void setTempoSemaforo(double tempoSemaforo) {
        this.tempoSemaforo = tempoSemaforo;
    }
}
