package logica;

import java.util.ArrayList;
import java.util.List;

public class Logica {
    private List<String[]> linhas = new ArrayList<>();


    public void seedLinhas(){
        for(int count = 0;count<9;count++){
            String[] aux = new String[9];
                for(int i = 0 ; i<9;i++){
                    aux[i] = " ";
                }
                linhas.add(aux);
        }
    }
    public List<String[]> getLinhas(){
        return this.linhas;
    }

}
