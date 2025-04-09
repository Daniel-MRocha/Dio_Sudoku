package main;

import logica.Logica;
import tabuleiro.Mesa;

public class App {
    public static void main(String[] args) {
        System.out.println("___Sudoku____");
        Mesa mesa = new Mesa();
        Logica logi = new Logica();

        logi.seedLinhas();
        var jogo = logi.getLinhas();
        jogo.get(4)[4]="4";

        //testes
        System.out.println(mesa.executaJogada(jogo));

    }
}
