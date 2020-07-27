package mc322.heroquest.itens;

import mc322.heroquest.mapa.Heroi;

public class PocaoForca extends Pocao {

    public PocaoForca() {
    	super();
    	this.bonus = 2;
    	this.nome += " de Forca";
    }
    //a pocao de forca fornece dados bonus de ataque pro heroi
    public void usar(Heroi heroi) {	
    	heroi.setBonusAtaque(bonus);
    }
}
