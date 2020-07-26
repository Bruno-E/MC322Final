package mc322.heroquest.main;

public class Obstaculo extends Elemento {
    
    public Obstaculo(Ponto posicao) {
        super(posicao, true);
    }
    public Obstaculo(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
    
}
