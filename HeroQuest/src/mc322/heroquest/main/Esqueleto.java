package mc322.heroquest.main;

public class Esqueleto extends Monstro {
	private static int VIDA_INICIAL = 3;
    
	public Esqueleto() {
    	this.vida = VIDA_INICIAL;
    	this.dadosAtaque = 1;
    	this.dadosDefesa = 2;
    	this.inteligencia = 1;
    	this.movimento = 4;
    	this.arma = new Arma(TipoDeArmas.PUNHO);
    }
    
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }
}
