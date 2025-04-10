package logica;

import java.util.Objects;


public class Lance {

    private String numero = " ";
    private int linha;
    private  int coluna;

    public Lance(int linha, int coluna , String numero) {
        this.numero = numero;
        this.linha = linha -1 ;
        this.coluna = coluna - 1;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lance lance)) return false;
        return linha == lance.linha && coluna == lance.coluna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linha, coluna);
    }


}
