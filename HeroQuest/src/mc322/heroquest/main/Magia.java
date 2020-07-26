package mc322.heroquest.main;

import java.util.*;

public abstract class Magia {

    public Magia() {
    }
    
    protected String nome;
    
    protected String getNome() {
    	return this.nome;
    }
    protected abstract void lancar();

}
