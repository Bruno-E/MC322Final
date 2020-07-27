package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.itens.TipoDeArmas;
import mc322.heroquest.main.DadoVermelho;

public class Esqueleto extends Monstro {
	private static int VIDA_INICIAL = 3;
    
	public Esqueleto(Ponto ponto) {
		super(ponto);
		this.nome = "Esqueleto";
    	this.vida = VIDA_INICIAL;
    	this.dadosAtaque = 1;
    	this.dadosDefesa = 2;
    	this.inteligencia = 1;
    	this.movimento = 4;
    	DadoVermelho dado = new DadoVermelho();
    	int arma = dado.jogar();
    	switch(arma) {
    		case 1:
    			this.arma = new Arma(TipoDeArmas.PUNHO);
    			break;
    		case 2:
    			this.arma = new Arma(TipoDeArmas.BASTAO);
    			break;
    		case 3:
    			this.arma = new Arma(TipoDeArmas.ESPADA_LONGA);
    			break;
    		case 4:
    			this.arma = new Arma(TipoDeArmas.ESPADA_CURTA);
    			break;
    		case 5:
    			this.arma = new Arma(TipoDeArmas.MACHADO_DE_COMBATE);
    			break;
    		case 6:
    			this.arma = new Arma(TipoDeArmas.LANCA);
    			break;
    			
    	}
    }
	public Esqueleto(int linha, int coluna) {
    	this(new Ponto(linha, coluna));

    }
    
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }

    
    @Override
	public void mover(Heroi heroi) {
    	
	}
    @Override
	public String toString(){
        return "Es";
    }
}
