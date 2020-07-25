package mc322.heroquest.main;

public class PocaoResiliencia extends Pocao{
	  
	public PocaoResiliencia() {
		this.bonus = 2;
	}
	   
	protected void usar(Heroi heroi) {	
	    heroi.setBonusDefesa(bonus);
	}
	   
	public String getInformation(){
	    return "Pocao de Resiliencia";
	}
}
