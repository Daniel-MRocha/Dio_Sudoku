package main.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.App.leitura;


public class Logica {
    private final List<String[]> gradeMestre = new ArrayList<>();
    private final List<Lance> preLances = new ArrayList<>();
    private final List<Lance> novosLances = new ArrayList<>();
    private final List<String> possiveisJogadas = Arrays.stream(new String[]{"1","2","3","4","5","6","7","8","9"}).toList();



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
    public String reiniciarGradeMestre(){
        novosLances.clear();
        gradeMestre.clear();
        preCarregamento();
        return "O tabuleiro foi reiniciado";
    }

    public String jogar(Lance lance)throws Exception{
        if(!preLances.contains(lance)) {
            gradeMestre.get(lance.getLinha())[lance.getColuna()] = lance.getNumero();
            novosLances.add(lance);
        return "Jogada executada";
        }else {
            return "Jogada ilegal !!";
        }
    }
    public  Lance executarLance() throws Exception{
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

    public String retrocederUltimajogada()throws Exception{
        int indice =(int) novosLances.size() - 1;
        Lance lance = novosLances.get(indice);
        if(!preLances.contains(lance)) {
            gradeMestre.get(lance.getLinha())[lance.getColuna()] = " ";
            novosLances.remove(lance);
            return "A jogada foi retrocedida !!";
        }else {
            return "Este retrocesso é ilegal !!";
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

    public String statusCheck(){

        StringBuffer msg = new StringBuffer();

       boolean linhasHorizontais = checkLinhasHorizontais();
       boolean linhasVerticais   = checkLinhasVerticais();
       boolean grade81 = grade81();

        if(linhasHorizontais){
            msg.append("\nTem algo errado na horizontal !!");
        }
        if(linhasVerticais){
            msg.append("\nTem algo errado na vertical  !!");
        }
        if(noveBlocos()){
            msg.append("\nTem algo errado em um bloco !!");
        }

        if(grade81){
            msg.append("\nVocê venceu =) , concluiu o desafio \n");
        }else if(novosLances.size()<=preLances.size()) {
            msg.append("Jogo não iniciado");
        }else{
            msg.append("Jogo em andamento");
        }
        return msg.toString();
    }

        private boolean checkLinhasHorizontais(){
            List<Boolean> linhas = seedLinhasHorizontais();
         return linhas.stream().anyMatch(e->e.equals(false));
        }
        private List<Boolean> seedLinhasHorizontais(){

        List<Boolean> resultadoAcumuladoH = new ArrayList<>();

        List<String[]> blocoH1 = gradeMestre.stream().limit(3).filter(e->!e.equals(" ")).toList();
        List<String[]> blocoH2 = gradeMestre.stream().skip(3).limit(3).filter(e->!e.equals(" ")).toList();
        List<String[]> blocoH3 = gradeMestre.stream().skip(6).limit(3).filter(e->!e.equals(" ")).toList();

        possiveisJogadas.forEach(numero -> {
            for (String[] linha : blocoH1) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    resultadoAcumuladoH.add(true);
                }else {
                    resultadoAcumuladoH.add(false);
                }
            }
            for (String[] linha : blocoH2) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    resultadoAcumuladoH.add(true);
                }else {
                    resultadoAcumuladoH.add(false);
                }
            }
            for (String[] linha : blocoH3) {
                long contador = Arrays.stream(linha).filter(e -> e.equals(numero)).count();
                if(contador<=1){
                    resultadoAcumuladoH.add(true);
                }else {
                    resultadoAcumuladoH.add(false);
                }
            }
        });
        return resultadoAcumuladoH;
    }
        private boolean checkLinhasVerticais(){
            List<Boolean> linhas = seedLinhasVerticais();
            return linhas.stream().anyMatch(e->e.equals(false));
        }
        private List<Boolean> seedLinhasVerticais(){

            List<Boolean> resultadoAcumuladoV = new ArrayList<>();

            List<String[]> blocoV1 = new ArrayList<>();
            List<String[]> blocoV2 = new ArrayList<>();
            List<String[]> blocoV3 = new ArrayList<>();

            List<String> auxSeed = new ArrayList<>();

            for(int coluna = 0; coluna<9; coluna++) {
                for (int linha = 0; linha < 9; linha++) {
                    auxSeed.add(gradeMestre.get(linha)[coluna]);
                }
                String[] auxArray = auxSeed.stream().toArray(e -> new String[e]);
                if(coluna<3){
                    blocoV1.add(auxArray);
                    auxSeed.clear();
                }else if(coluna>3 && coluna<6){
                    blocoV2.add(auxArray);
                    auxSeed.clear();
                }else {
                    blocoV3.add(auxArray);
                    auxSeed.clear();
                }
            }

            possiveisJogadas.forEach(numero -> {
                for (String[] linha : blocoV1) {
                    long contador = Arrays.stream(linha).filter(e->!e.equals(" ")).filter(e -> e.equals(numero)).count();
                    if(contador<=1){
                        resultadoAcumuladoV.add(true);
                    }else {
                        resultadoAcumuladoV.add(false);
                    }
                }
                for (String[] linha : blocoV2) {
                    long contador = Arrays.stream(linha).filter(e->!e.equals(" ")).filter(e -> e.equals(numero)).count();
                    if(contador<=1){
                        resultadoAcumuladoV.add(true);
                    }else {
                        resultadoAcumuladoV.add(false);
                    }
                }
                for (String[] linha : blocoV3) {
                    long contador = Arrays.stream(linha).filter(e->!e.equals(" ")).filter(e -> e.equals(numero)).count();
                    if(contador<=1){
                        resultadoAcumuladoV.add(true);
                    }else {
                        resultadoAcumuladoV.add(false);
                    }
                }
            });
            return resultadoAcumuladoV;
        }
        private boolean grade81(){

            List<String> gradeFlat = gradeMestre.stream()
                    .flatMap(linha -> Arrays.stream(linha))
                    .toList();

            //confere 9 de cada algarismo
            List<Boolean> noveDeCada = new ArrayList<>();
            possiveisJogadas.forEach(numero -> {
                final long contagem = gradeFlat.stream()
                        .filter(e -> !e.equals(" "))
                        .filter(e-> e.equals(numero))
                        .count();
                if(contagem==9) {
                    noveDeCada.add(true);
                }
            });
            return (noveDeCada.stream().count()==9)?true:false;
        }
        private boolean noveBlocos(){

        List<Boolean> resultadoAcumulado = new ArrayList<>();

        List<String> bloco1 = new ArrayList<>();
        List<String> bloco2 = new ArrayList<>();
        List<String> bloco3 = new ArrayList<>();
        List<String> bloco4 = new ArrayList<>();
        List<String> bloco5 = new ArrayList<>();
        List<String> bloco6 = new ArrayList<>();
        List<String> bloco7 = new ArrayList<>();
        List<String> bloco8 = new ArrayList<>();
        List<String> bloco9 = new ArrayList<>();

        //seed dos blocos
            gradeMestre.stream().limit(3)
                .forEach(linha->{
                    for(int indice = 0;indice<9;indice++){
                        if(indice<3){
                            bloco1.add(linha[indice]);
                        }
                        else if(indice>=3 && indice<6){
                            bloco2.add(linha[indice]);
                        }else {
                            bloco3.add(linha[indice]);
                        }
                    }
                });

            gradeMestre.stream().skip(3).limit(3)
                    .forEach(linha->{
                        for(int indice = 0;indice<9;indice++){
                            if(indice<3){
                                bloco4.add(linha[indice]);
                            }
                            else if(indice>=3 && indice<6){
                                bloco5.add(linha[indice]);
                            }else {
                                bloco6.add(linha[indice]);
                            }
                        }
                    });

            gradeMestre.stream().skip(6).limit(3)
                    .forEach(linha->{
                        for(int indice = 0;indice<9;indice++){
                            if(indice<3){
                                bloco7.add(linha[indice]);
                            }
                            else if(indice>=3 && indice<6){
                                bloco8.add(linha[indice]);
                            }else {
                                bloco9.add(linha[indice]);
                            }
                        }
                    });

            possiveisJogadas.stream()
                            .forEach(jogada -> {
                                final long auxContagem = bloco1.stream().filter(elemento->elemento.equals(jogada)).count();
                                if(auxContagem<=1){
                                    resultadoAcumulado.add(true);
                                }else {
                                    resultadoAcumulado.add(false);
                                }
                            });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco2.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco3.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco4.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco5.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco6.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco7.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco8.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });
            possiveisJogadas.stream()
                    .forEach(jogada -> {
                        final long auxContagem = bloco9.stream().filter(elemento->elemento.equals(jogada)).count();
                        if(auxContagem<=1){
                            resultadoAcumulado.add(true);
                        }else {
                            resultadoAcumulado.add(false);
                        }
                    });

            return resultadoAcumulado.stream().anyMatch(ele->ele.equals(false));
        }
    }



