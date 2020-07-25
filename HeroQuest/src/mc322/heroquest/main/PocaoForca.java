package mc322.heroquest.main;

import java.util.*;

public class PocaoForca extends Pocao {

    public PocaoForca() {
    	this.bonus = 2;
    }
   
    protected void usar(Heroi heroi) {	
    	heroi.setBonusAtaque(bonus);
    }
    public String getInformation(){
        return "Pocao de Forca";
    }

}
