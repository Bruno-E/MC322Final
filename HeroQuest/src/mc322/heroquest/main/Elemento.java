package mc322.heroquest.main;

public abstract class Elemento {

    protected boolean visivel;
    protected Ponto posicao;
    
    public Elemento(Ponto posicao) {
        this.posicao = posicao;
    }
    
    public Elemento(int linha, int coluna) {
        setPosicao(linha, coluna);
    }

    public Elemento(Ponto posicao, boolean visibilidade) {
        this(posicao);
        visivel = visibilidade;
    }
    
    public Elemento(int linha, int coluna, boolean visibilidade) {
        this(linha, coluna);
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

    public void setVisivel(boolean visibilidade) {
        visivel = visibilidade;
    }

}
