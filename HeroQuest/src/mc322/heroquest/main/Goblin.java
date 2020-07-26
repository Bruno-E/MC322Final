package mc322.heroquest.main;

public class Goblin extends Monstro {
	private static int VIDA_INICIAL = 3;
    public Goblin() {
    	this.vida = 3;
    	this.dadosAtaque = 2;
    	this.dadosDefesa = 1;
    	this.inteligencia = 1;
    	this.movimento = 5;
    	this.arma = new Arma(TipoDeArmas.PUNHAL);
    	this.noPunhais = 4;
    }
    
    private int noPunhais;
    
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }
}
