package mc322.heroquest.itens;

import mc322.heroquest.mapa.ElementoCombate;

public abstract class MagiaDefensiva extends Magia{
	//as magias defensivas possuem comportamentos diversos, mas nao possuem um alvo inimigo para receber 
	public abstract void lancar(ElementoCombate origem);
}
