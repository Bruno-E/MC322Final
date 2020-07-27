package mc322.heroquest.itens;

import mc322.heroquest.mapa.Heroi;

public class PocaoResiliencia extends Pocao{
	  
	public PocaoResiliencia() {
		super();
		this.bonus = 2;
		this.nome += " de Resiliencia";
	}
	//a pocao de resiliencia fornece dados de defsa bonus
	public void usar(Heroi heroi) {	
	    heroi.setBonusDefesa(bonus);
	}
	   
}
