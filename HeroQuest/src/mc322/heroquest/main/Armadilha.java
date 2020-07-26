package mc322.heroquest.main;

public abstract class Armadilha extends Elemento implements Guardavel{
	
	protected int dano;
	
    protected Armadilha(Ponto posicao) {
    	super(posicao, false);
    }
    public Armadilha(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }

    protected abstract void ativar(Heroi heroi);
    
    public void coletar(Heroi heroi) {
    	ativar(heroi);
    }
    @Override 
    protected String toString(){
        return "Ar"
    }

}
