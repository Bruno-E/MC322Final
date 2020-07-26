package mc322.heroquest.main;

public abstract class Armadilha extends Elemento {
//
    protected Armadilha(Ponto posicao) {
    	super(posicao);
    	this.visivel = false;
    }

    protected int dano;

    protected abstract void ativar(Heroi heroi);

}
