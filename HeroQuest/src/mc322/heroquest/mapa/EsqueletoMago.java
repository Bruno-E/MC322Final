package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.itens.MissilMagico;
import mc322.heroquest.itens.TipoDeArmas;

public class EsqueletoMago extends Monstro {
	private static int VIDA_INICIAL = 1;
	
    public EsqueletoMago(Ponto ponto) {
    	super(ponto);
    	this.nome = "Esqueleto Mago";
    	this.vida = VIDA_INICIAL;
    	this.dadosAtaque = 1;
    	this.dadosDefesa = 1;
    	this.inteligencia = 3;
    	this.movimento = 3;
    	this.arma = new Arma(TipoDeArmas.PUNHO);
    }
    public EsqueletoMago(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }

    public MissilMagico missil;
    //possui restaura vida pois pode carregar uma cura simples
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }
    @Override
	public String toString(){
        return "EM";
    }

}
