package main;

import main.logica.Logica;
import main.tabuleiro.Mesa;

import java.util.Scanner;

public class App {
    public static Scanner leitura = new Scanner(System.in);


    public static void main(String[] args) {


        Mesa mesa = new Mesa();
        Logica operacao = new Logica();

        System.out.println("""
         ______________________________________________
        /________________Sudoku_______________________/
        De cima para baixo , linha 1 , linha 2 ...
        Da esquerda para direita, coluna 1, coluna 2...
        """);


        operacao.preCarregamento();
        mesa.atualizaJogo(operacao.getGradeMestre());

    boolean loop = true;
    while (loop){
            String fluxo = menu();
        switch (fluxo){
            case "1":
                try {
                    System.out.println(operacao.jogar(operacao.executarLance()));

                }catch (Exception e){
                    System.out.println("Parametro inválido !!");
                }
                break;
            case "2":
                System.out.println(mesa.atualizaJogo(operacao.getGradeMestre()));
                System.out.println(operacao.statusCheck());
                break;
            case "3":
                try {
                    System.out.println(operacao.apagar(operacao.apagarLance()));
                }catch (Exception e){
                System.out.println("Parametro inválido !!");
                }
                break;
            case "4":
                try {
                    System.out.println(operacao.apagarUltimajogada());
                }catch (Exception e){
                    System.out.println("Erro no retrocesso de jogada" + e.getMessage());
                }
                break;
            case "5":
                System.out.println(operacao.reiniciarGradeMestre());
                break;
            case "6":
                System.out.println("Saindo do jogo");
                loop = false;
                break;
            }
        }
    leitura.close();
    }

    public static String menu(){
        System.out.print("""
                ________________
                MENU:
                1) Jogar:
                2) Status
                3) Apagar jogada
                4) Retroceder uĺtima jogada
                5) Reiniciar tabuleiro
                6) Sair
                ________________
                Opção :\s""");


        return leitura.next();
    }

}
