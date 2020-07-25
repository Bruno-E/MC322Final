package mc322.heroquest.main;

public class PocaoVelocidade extends Pocao{
		PocaoVelocidade() {
			this.bonus = 2;
		}
	   
	   protected void usar(Heroi heroi) {	
	    	heroi.setBonusDefesa(bonus);
	   }
	   
	   public String getInformation(){
	        return "Pocao de Velocidade";
	   }
}
