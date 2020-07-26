package mc322.heroquest.main;

import java.util.*;

public class Armadura extends Item {
    int bonus;
    public Armadura() {
    	this.nome = "Armadura";
        this.bonus = 2;
    }  
	protected int getDados(Heroi heroi) {	
	    return bonus;
	}
    public string getInformation(){
        return nome;
    }
}
