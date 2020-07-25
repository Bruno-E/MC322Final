package mc322.heroquest.main;

import java.util.*;

public class Arma extends Item {

    public Arma(TipoDeArmas arma) {
    	this.arma = arma;
    	if(arma == TipoDeArmas.PUNHAL) {
    		this.descartavel = true;
    	}
    	else {
    		this.descartavel = false;
    	}
    }
    private boolean descartavel;
    private TipoDeArmas arma;
    
    public String getInformation(){
        return arma.toString();
    }

}
