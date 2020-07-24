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

}
