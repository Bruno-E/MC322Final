package mc322.heroquest.itens;

import mc322.heroquest.mapa.Heroi;

public class PocaoCura extends Pocao {

    public PocaoCura() {
    	super();
    	this.bonus = 4;
    	this.nome += " de Cura";
    }
    //a pocao de cura restaura a vida do heroi
    @Override
	public void usar(Heroi heroi) {
    	heroi.restauraVida(bonus);
    }

}
