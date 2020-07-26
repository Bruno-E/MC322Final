package mc322.heroquest.main;

public abstract class Pocao extends Item implements Guardavel {
	
    public Pocao() {
    	this.nome = "Pocao";
    }

    protected int bonus;

    protected abstract void usar(Heroi heroi);
    
    public void coletar(Heroi heroi) {
    	heroi.adcItem(this);
    }

}
