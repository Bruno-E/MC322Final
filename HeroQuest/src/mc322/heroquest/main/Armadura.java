package mc322.heroquest.main;

public class Armadura extends Item {

	//uma armadura tera um tipo, que definira seu bonus e seu nome
    public Armadura(TipoDeArmaduras armadura) {
    	this.armadura = armadura;
    	this.nome = armadura.toString();
    }
    
    private TipoDeArmaduras armadura;
    
    protected String getInformation(){
        return nome;
    }
    
    protected int getBonus() {
    	return this.armadura.getBonus();
    }

}
