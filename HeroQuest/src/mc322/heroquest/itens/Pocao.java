package mc322.heroquest.itens;

import mc322.heroquest.mapa.Coletavel;
import mc322.heroquest.mapa.Heroi;
import mc322.heroquest.mapa.Mapa;

public abstract class Pocao extends Item implements Coletavel {
	
    public Pocao() {
    	this.nome = "Pocao";
    }
    //as pocoes irao fornecer um bonus ao heroi apos seu uso
    //sao utilizadas pelo heroi pelo metodo usar
    protected int bonus;

    public abstract void usar(Heroi heroi);
    
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	return heroi.adcItem(this);
    }

}
