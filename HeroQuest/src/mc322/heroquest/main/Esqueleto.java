package mc322.heroquest.main;

import java.util.*;

public class Esqueleto extends Monstro {

    public Esqueleto() {
    	this.vida = 3;
    	this.dadosAtaque = 1;
    	this.dadosDefesa = 2;
    	this.inteligencia = 1;
    	this.movimento = 4;
    	this.arma = new Arma(TipoDeArmas.PUNHO);
    }

}