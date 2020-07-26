package mc322.heroquest.main;

public abstract class Pocao extends Item implements Coletavel {
	
    public Pocao() {
    	this.nome = "Pocao";
    }

    protected int bonus;

    protected abstract void usar(Heroi heroi);
    
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	return heroi.adcItem(this);
    }

}
