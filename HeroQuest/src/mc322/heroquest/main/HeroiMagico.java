package mc322.heroquest.main;

import java.util.*;

public abstract class HeroiMagico extends Heroi {

    protected HeroiMagico(String nome, Ponto posicao) {
    	super(nome, posicao);
    }

    protected Magia[] magias;
    
    @Override protected boolean eMagico() {
    	return false;
    }

}
