package mc322.heroquest.mapa;

public class Obstaculo extends Elemento {
    
    public Obstaculo(Ponto posicao) {
        super(posicao, true);
    }
    public Obstaculo(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
    @Override
    public String toString(){
        return"Ob";
    }
    
}
