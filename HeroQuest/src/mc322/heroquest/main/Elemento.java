package mc322.heroquest.main;

public abstract class Elemento {

    protected boolean visivel, vazio;
    protected Ponto posicao;
    
    protected Elemento(boolean vazio, Ponto posicao, boolean visibilidade) {
        this.posicao = posicao;
        this.vazio = vazio;
        visivel = visibilidade;
    }
    
    protected Elemento(boolean vazio, int linha, int coluna, boolean visibilidade) {
        setPosicao(linha, coluna);
        this.vazio = vazio;
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
    
    protected boolean getVisivel() {
    	return visivel;
    }
    protected void setVisivel(boolean visibilidade) {
        visivel = visibilidade;
    }
    protected boolean getVazio() {
    	return vazio;
    }
    protected void setVazio(boolean vazio) {
        this.vazio = vazio;
    }

}
