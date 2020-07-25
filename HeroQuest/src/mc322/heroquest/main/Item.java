package mc322.heroquest.main;

import java.util.*;

public abstract class Item {

    public Item() {
    }

    protected boolean descartavel;
    protected String nome;
    
    public String getInformation() {
    	return this.nome;
    }

}
