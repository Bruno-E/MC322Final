package mc322.heroquest.main;

import java.util.*;

public class PocaoForca extends Pocao {

    public PocaoForca() {
    	super();
    	this.bonus = 2;
    	this.nome += " de Forca";
    }
   
    protected void usar(Heroi heroi) {	
    	heroi.setBonusAtaque(bonus);
    }
}
