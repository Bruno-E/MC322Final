package mc322.heroquest.mapa;

public abstract class Armadilha extends Elemento implements Coletavel{
	//uma armadilha padrao contem apenas o dano e sua posicao, alem de uma funcao ativar
	//no jogo, armadilhas possuem diferentes efeitos alem de causar dano
	//escolhemos implementar a armadilha basica de flecha que causa 1 de dano
	protected int dano;
	
    public Armadilha(Ponto posicao) {
    	super(posicao, false);
    }
    public Armadilha(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }

    protected abstract void ativar(Heroi heroi);
    
    //ao vasculhar um bau, um heroi pode acabar ativando uma armadilha
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	ativar(heroi);
    	return true;
    }
    @Override 
    public String toString(){
        return "Ar";
    }

}
