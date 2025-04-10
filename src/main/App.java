package main;

import logica.Lance;
import logica.Logica;
import tabuleiro.Mesa;

import java.util.Scanner;

public class App {
    public static Scanner leitura = new Scanner(System.in);


    public static void main(String[] args) {


        Mesa mesa = new Mesa();
        Logica operacao = new Logica();

        System.out.println("""
         _________________________
        /_________Sudoku_________/""");

        operacao.preCarregamento();
        mesa.atualizaJogo(operacao.getGradeMestre());

    boolean loop = true;
    while (loop){
            String fluxo = menu();
        switch (fluxo){
            case "1":
                try {
                    System.out.println(operacao.jogar(executarJogada()));
                }catch (Exception e){
                    System.out.println("Parametro inválido");;
                }
                break;
            case "2":
                System.out.println(mesa.atualizaJogo(operacao.getGradeMestre()));
                break;
            case "3":
                System.out.println("Finalizado");
                loop = false;
                break;
        }

    }


    }

    public static String menu(){
        System.out.print("""
                ________________
                MENU:
                1) Jogar:
                2) Mostrar mesa
                3) Sair
                ________________
                Opção :\s""");
        return leitura.next();
    }
    public static Lance executarJogada() throws Exception{
        int linha;
        int coluna;
        String jogada;

        System.out.println("---------------JOGADA:");
        System.out.print("---------------------->Linha  : ");
        linha = leitura.nextInt();

        System.out.print("---------------------->Coluna : ");
        coluna = leitura.nextInt();

        System.out.print("---------------------->Jogada : ");
        jogada = leitura.next();

        return new Lance(linha,coluna,jogada);
    }
}
