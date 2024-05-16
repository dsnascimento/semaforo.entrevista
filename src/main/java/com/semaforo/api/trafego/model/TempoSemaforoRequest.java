package com.semaforo.api.trafego.model;


import lombok.Getter;
import lombok.Setter;

/*Não preciso Colocar os Getters e Setters com (ant + insert) padrões pois a biblioteca lombok ja faz isso para mim ai basta por as tags*/
@Getter
@Setter
public class TempoSemaforoRequest {
    private double distancia;
    private double velocidadePermitida;
    private double aceleracao;
}
