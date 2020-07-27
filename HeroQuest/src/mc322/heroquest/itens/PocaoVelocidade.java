package mc322.heroquest.itens;

import mc322.heroquest.mapa.Heroi;

public class PocaoVelocidade extends Pocao{
		public PocaoVelocidade() {
			super();
			this.bonus = 2;
			this.nome += " de Velocidade";
		}
	   //a pocao de velocidade fornece dados de movimento bonus
	   public void usar(Heroi heroi) {	
	    	heroi.setBonusMovimento(bonus);
	   }

}
