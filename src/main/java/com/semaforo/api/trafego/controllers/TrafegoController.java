package com.semaforo.api.trafego.controllers;

import com.semaforo.api.trafego.model.TempoSemaforoRequest;
import com.semaforo.api.trafego.model.TempoSemaforoResponse;
import org.springframework.web.bind.annotation.*;

/*Aqui defino os Endpoints da API e trato a requisição Http que no caso são calcular-tempo-semaforo*/

/*Além de efetuar os calculos para dizer qual tempo para que o proximo sinal seja aberto*/


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TrafegoController {

    @PostMapping("/calcular-tempo-semaforo")
    public @ResponseBody TempoSemaforoResponse calcularTempoSemaforo(@RequestBody TempoSemaforoRequest request) {
        double distancia = request.getDistancia();
        double velocidadePermitida = request.getVelocidadePermitida() / 3.6;
        double aceleracao = request.getAceleracao();


        double tempoAceleracao = velocidadePermitida / aceleracao;


        double distanciaAceleracao = 0.5 * aceleracao * Math.pow(tempoAceleracao, 2);

        double tempoTotal;

        /*Código para saber se será preciso percorrer a distancia total ou não para bater velocidade permitida que no caso é o limitador da condição*/
        /*Ai nesse caso o veiculo ocntinuara acelerando até bater essa velocidade*/
        /*Os demais são tratativas para o caso contrário para saber como o tempo será calculado de fato, se a distancia for suficiente ou não*/
        if (distanciaAceleracao >= distancia) {

            tempoTotal = Math.sqrt(2 * distancia / aceleracao);
        } else {

            double distanciaRestante = distancia - distanciaAceleracao;
            double tempoRestante = distanciaRestante / velocidadePermitida;
            tempoTotal = tempoAceleracao + tempoRestante;
        }

        /*Foi oque o desafio pediu que foi os 3 segundos de espera*/
        double tempoSemaforo = tempoTotal - 3;

        return new TempoSemaforoResponse(tempoSemaforo);
    }
}
