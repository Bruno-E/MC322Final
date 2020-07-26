package mc322.heroquest.main;

public class Ponto {

    private int linha;
    private int coluna;
    
    public Ponto(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
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
    
    public void setCoord(int linha, int coluna) {
    	setLinha(linha);
    	setColuna(coluna);
    }
    
}
