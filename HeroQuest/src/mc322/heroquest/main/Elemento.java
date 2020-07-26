package mc322.heroquest.main;

public abstract class Elemento {

    protected boolean visivel;
    protected Ponto posicao;
    
    protected Elemento(Ponto posicao, boolean visibilidade) {
        this.posicao = posicao;
        visivel = visibilidade;
    }
    
    protected Elemento(int linha, int coluna, boolean visibilidade) {
        setPosicao(linha, coluna);
        visivel = visibilidade;
    }

    protected int getLinha() {
        return posicao.getLinha();
    }
    protected int getColuna() {
        return posicao.getColuna();
    }
    protected Ponto getPosicao() {
        return posicao;
    }
    
    protected void setPosicao(int linha, int coluna) {
        posicao = new Ponto(linha, coluna);
    }
    protected void setPosicao(Ponto ponto) {
        posicao = ponto;
    }
    
    protected boolean getVisivel() {
    	return visivel;
    }
    protected void setVisivel(boolean visibilidade) {
        visivel = visibilidade;
    }
    @Override 
    protected String toString(){
        return "An"
    }

}
