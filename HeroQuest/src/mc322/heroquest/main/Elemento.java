package mc322.heroquest.main;

public abstract class Elemento {

    protected boolean visivel, vazio;
    protected Ponto posicao;
    
    protected Elemento(boolean vazio, Ponto posicao, boolean visibilidade) {
        this.posicao = posicao;
        this.vazio = vazio;
        visivel = visibilidade;
    }
    
    public Elemento(boolean vazio, int linha, int coluna, boolean visibilidade) {
        setPosicao(linha, coluna);
        this.vazio = vazio;
        visivel = visibilidade;
    }

    public int getLinha() {
        return posicao.getLinha();
    }
    public int getColuna() {
        return posicao.getColuna();
    }
    public Ponto getPosicao() {
        return posicao;
    }
    public void setPosicao(int linha, int coluna) {
        posicao = new Ponto(linha, coluna);
    }
    
    public boolean getVisivel() {
    	return visivel;
    }
    public void setVisivel(boolean visibilidade) {
        visivel = visibilidade;
    }
    public boolean getVazio() {
    	return vazio;
    }
    public void setVazio(boolean vazio) {
        this.vazio = vazio;
    }

}
