package mc322.heroquest.main;

import java.util.*;

public abstract class HeroiMagico extends Heroi {

    protected HeroiMagico(String nome) {
    	super(nome);
    }

    protected Magia[] magias;
    
    @Override protected boolean eMagico() {
    	return false;
    }

}
