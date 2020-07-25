package mc322.heroquest.main;

import java.util.*;

public class Goblin extends Monstro {

    public Goblin() {
    	this.vida = 4;
    	this.dadosAtaque = 2;
    	this.dadosDefesa = 1;
    	this.inteligencia = 1;
    	this.movimento = 5;
    	this.arma = new Arma(TipoDeArmas.PUNHAL);
    	this.noPunhais = 4;
    }
    
    private int noPunhais;
    
    
}