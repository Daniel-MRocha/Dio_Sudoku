package main.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Logica {
    private List<String[]> gradeMestre = new ArrayList<>();
    private final List<Lance> preLances = new ArrayList<>();
    private List<Lance> novosLances = new ArrayList<>();



    private void seedGradeMestre(){
        for(int count = 0;count<9;count++){
            String[] aux = new String[9];
                for(int i = 0 ; i<9;i++){
                    aux[i] = " ";
                }
                gradeMestre.add(aux);
        }
    }

    public List<String[]> getGradeMestre(){
        return this.gradeMestre;
    }

    public String jogar(Lance lance)throws Exception{
        if(!preLances.contains(lance)) {
            gradeMestre.get(lance.getLinha())[lance.getColuna()] = lance.getNumero();
        return "Jogada executada";
        }else {
            return "Jogada ilegal !!";
        }
    }

    public void preCarregamento(){
        seedGradeMestre();

        //linha 1
        this.preLances.add(new Lance(1,1,"4"));
        this.preLances.add(new Lance(1,2,"1"));
        this.preLances.add(new Lance(1,8,"8"));
        this.preLances.add(new Lance(1,9,"5"));

        //linha 2
        this.preLances.add(new Lance(2,2,"7"));
        this.preLances.add(new Lance(2,5,"4"));
        this.preLances.add(new Lance(2,8,"9"));

        //linha 3
        this.preLances.add(new Lance(3,5,"1"));

        //linha 4
        this.preLances.add(new Lance(4,1,"7"));
        this.preLances.add(new Lance(4,3,"2"));
        this.preLances.add(new Lance(4,7,"8"));
        this.preLances.add(new Lance(4,9,"3"));

        //linha 5
        this.preLances.add(new Lance(5,3,"6"));
        this.preLances.add(new Lance(5,4,"4"));
        this.preLances.add(new Lance(5,6,"2"));
        this.preLances.add(new Lance(5,7,"9"));

        //linha 6
        this.preLances.add(new Lance(6,3,"1"));
        this.preLances.add(new Lance(6,4,"8"));
        this.preLances.add(new Lance(6,6,"7"));
        this.preLances.add(new Lance(6,7,"5"));

        //linha 7
        this.preLances.add(new Lance(7,1,"8"));
        this.preLances.add(new Lance(7,9,"1"));

        //linha 8
        this.preLances.add(new Lance(8,2,"3"));
        this.preLances.add(new Lance(8,8,"7"));

        //linha 9
        this.preLances.add(new Lance(9,2,"9"));
        this.preLances.add(new Lance(9,3,"7"));
        this.preLances.add(new Lance(9,7,"3"));
        this.preLances.add(new Lance(9,8,"2"));

        for (Lance preLance : preLances) {
            gradeMestre.get(preLance.getLinha())[preLance.getColuna()] = preLance.getNumero();
        }

        novosLances.addAll(preLances);
    }

    public String jogoCheck(){

        List<String> gradeFlat = gradeMestre.stream()
                .flatMap(linha -> Arrays.stream(linha))
                .toList();

        List<String> numerosJogados = Arrays.stream(new String[]{"1","2","3","4","5","6","7","8","9"}).toList();

        //confere 9 de cada algarismo
        List<Boolean> noveDeCada = new ArrayList<>();
        numerosJogados.forEach(numero -> {
           long contagem = gradeFlat.stream()
                   .filter(e -> !e.equals(" "))
                   .filter(e-> e.equals(numero))
                   .count();
                    noveDeCada.add(contagem == 9);
       });

        //confere 1 algarismo por linha, em bloco de 3 linhas horizontais
        List<Boolean> linhasHorizontais = new ArrayList<>();

        List<String[]> blocoH1 = gradeMestre.stream().limit(3).filter(e->!e.equals(" ")).toList();
        List<String[]> blocoH2 = gradeMestre.stream().skip(3).limit(3).filter(e->!e.equals(" ")).toList();
        List<String[]> blocoH3 = gradeMestre.stream().skip(6).limit(3).filter(e->!e.equals(" ")).toList();

        numerosJogados.forEach(numero -> {
            for (String[] linha : blocoH1) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    linhasHorizontais.add(true);
                }else {
                    linhasHorizontais.add(false);
                }
            }
            for (String[] linha : blocoH2) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    linhasHorizontais.add(true);
                }else {
                    linhasHorizontais.add(false);
                }
            }
            for (String[] linha : blocoH3) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    linhasHorizontais.add(true);
                }else {
                    linhasHorizontais.add(false);
                }
            }
        });

        //confere 1 algarismo por linha, em bloco de 3 linhas verticais
        List<Boolean> linhasVerticais = new ArrayList<>();

        List<String[]> blocoV1 = new ArrayList<>();
        List<String[]> blocoV2 = new ArrayList<>();
        List<String[]> blocoV3 = new ArrayList<>();

        List<String> auxSeed = new ArrayList<>();

        for(int coluna = 0; coluna<8; coluna++) {
            for (int linha = 0; linha < 8; linha++) {
                    auxSeed.add(gradeMestre.get(linha)[coluna]);
            }
            String[] auxArray = auxSeed.stream().toArray(e -> new String[e]);
            if(coluna<4){
                blocoV1.add(auxArray);
                auxSeed.clear();
            } if(coluna>3 && coluna<7){
                blocoV2.add(auxArray);
                auxSeed.clear();
            }else {
                    blocoV3.add(auxArray);
                    auxSeed.clear();
            }
        }

        //todo teste do método
       blocoV1.stream().forEach(e -> System.out.print(e + " "));

        return " ";

        }

    }



