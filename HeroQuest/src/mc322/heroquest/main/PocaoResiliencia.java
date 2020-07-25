package mc322.heroquest.main;

public class PocaoResiliencia extends Pocao{
	  
	public PocaoResiliencia() {
		super();
		this.bonus = 2;
		this.nome += " de Resiliencia";
	}
	   
	protected void usar(Heroi heroi) {	
	    heroi.setBonusDefesa(bonus);
	}
	   
}
