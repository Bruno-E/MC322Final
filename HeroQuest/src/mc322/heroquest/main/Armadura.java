package mc322.heroquest.main;

import java.util.*;

public class Armadura extends Item {


    public Armadura(TipoDeArmaduras armadura) {
    	this.armadura = armadura;
    	this.nome = armadura.toString();
    }

    
    private TipoDeArmaduras armadura;
    
    protected String getInformation(){
        return nome;
    }
    
    protected int getBonus() {
    	return this.armadura.getBonus();
    }

}
