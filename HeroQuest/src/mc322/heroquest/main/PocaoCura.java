package mc322.heroquest.main;

public class PocaoCura extends Pocao {

    public PocaoCura() {
    	super();
    	this.bonus = 4;
    	this.nome += " de Cura";
    }
    
    @Override
    protected void usar(Heroi heroi) {
    	heroi.restauraVida(bonus);
    }

}
