package mc322.heroquest.main;

public class PocaoVelocidade extends Pocao{
		PocaoVelocidade() {
			super();
			this.bonus = 2;
			this.nome += " de Velocidade";
		}
	   //a pocao de velocidade fornece dados de movimento bonus
	   protected void usar(Heroi heroi) {	
	    	heroi.setBonusMovimento(bonus);
	   }

}
