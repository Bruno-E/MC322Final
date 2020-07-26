package mc322.heroquest.main;

public abstract class Armadilha extends Elemento implements Guardavel{
//
    protected Armadilha(Ponto posicao) {
    	super(posicao, false);
    }

    protected int dano;

    protected abstract void ativar(Heroi heroi);
    
    public void coletar(Heroi heroi) {
    	ativar(heroi);
    }

}
