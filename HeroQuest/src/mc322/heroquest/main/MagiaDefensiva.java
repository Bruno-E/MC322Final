package mc322.heroquest.main;

public abstract class MagiaDefensiva extends Magia{
	//as magias defensivas possuem comportamentos diversos, mas nao possuem um alvo inimigo para receber 
	protected abstract void lancar(ElementoCombate origem);
}
