package main;

import logica.Logica;
import tabuleiro.Mesa;

public class App {
    public static void main(String[] args) {
        System.out.println("___Sudoku____");
        Mesa mesa = new Mesa();
        Logica operacao = new Logica();


        operacao.preCarremento();
        mesa.atualizaJogo(operacao.getGradeMestre());


        //testes
        System.out.println(mesa.atualizaJogo(operacao.getGradeMestre()));

    }
}
