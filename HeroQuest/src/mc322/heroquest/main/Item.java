package mc322.heroquest.main;

public abstract class Item implements Coletavel{

    public Item() {
    }

    protected boolean descartavel;
    protected String nome;
    
    protected String getInformation() {
    	return this.nome;
    }

}
