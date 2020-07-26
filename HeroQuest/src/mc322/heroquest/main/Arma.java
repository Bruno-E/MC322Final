package mc322.heroquest.main;

public class Arma extends Item {

    public Arma(TipoDeArmas arma) {
    	this.arma = arma;
    	if(arma == TipoDeArmas.PUNHAL) {
    		this.descartavel = true;
    		this.alcance = 5;
    	}
    	else {
    		this.descartavel = false;
    		this.alcance = 1;
    	}
    	this.nome = arma.toString();
    }
    
    private int alcance;
    private boolean descartavel;
    private TipoDeArmas arma;
    
    public String getInformation(){
        return nome;
    }
    
    int getAlcance() {
    	return this.alcance;
    }
    
    int getBonus() {
    	return this.arma.getBonus();
    }

}
