package mc322.heroquest.mapa;

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
    
    
    // retorna true se ponto esta ao alcance de this
    public boolean aoAlcance(Ponto ponto, int alcance) {
    	if (Math.pow(ponto.getLinha() - linha, 2) + Math.pow(ponto.getColuna() - coluna, 2) < Math.pow(alcance, 2)) 
    		return true;
    	else return false;
    }
    public boolean aoAlcance(int linha, int coluna, int alcance) {
    	return aoAlcance(new Ponto(linha, coluna), alcance);
    }
    
    
    // retorna a posicao correspondente a direcao dada
    public Ponto novaPosicao(String direcao) {
        switch(direcao) {
            case "w":
                return new Ponto(this.getLinha() - 1, this.getColuna());
            case "a":
                return new Ponto(this.getLinha(), this.getColuna() - 1);
            case "s":
                return new Ponto(this.getLinha() + 1, this.getColuna());
            case "d":
                return new Ponto(this.getLinha(), this.getColuna() + 1);
        }
        return null;
    }
    
}
