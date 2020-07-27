package mc322.heroquest.itens;

public class Armadura extends Item {

	//uma armadura tera um tipo, que definira seu bonus e seu nome
    public Armadura(TipoDeArmaduras armadura) {
    	this.armadura = armadura;
    	this.nome = armadura.toString();
    }
    
    private TipoDeArmaduras armadura;
    
    public String getInformation(){
        return nome;
    }
    
    public int getBonus() {
    	return this.armadura.getBonus();
    }

}
