package mc322.heroquest.main;

import java.util.*;

public abstract class Pocao extends Item {
	
    public Pocao() {
    	this.nome = "Pocao";
    }

    protected int bonus;

    protected abstract void usar(Heroi heroi);

}
