package main.tabuleiro;

import java.util.List;

public class Mesa {

    public String atualizaJogo(List<String[]> jogadas){
        StringBuffer sb = new StringBuffer();

        for (String[] jogada : jogadas) {
            sb.append("| "+jogada[0] + " | "+jogada[1] + " | "+jogada[2] + " | "+jogada[3] + " | "+jogada[4] + " | "+jogada[5] +
                    " | "+jogada[6] + " | "+jogada[7] + " | "+jogada[8] +" |\n");
        }
        return sb.toString();
    }
}
