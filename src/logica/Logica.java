package logica;

import java.util.ArrayList;
import java.util.List;


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


}
