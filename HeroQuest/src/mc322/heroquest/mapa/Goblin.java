package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.itens.TipoDeArmas;
import mc322.heroquest.main.DadoCombate;
import mc322.heroquest.main.Lado;

public class Goblin extends Monstro {
	
	private int noPunhais;
	private static int VIDA_INICIAL = 2;
	
    public Goblin(Ponto ponto) {
    	super(ponto);
    	this.nome = "Goblin";
    	this.vida = 3;
    	this.dadosAtaque = 2;
    	this.dadosDefesa = 1;
    	this.inteligencia = 1;
    	this.movimento = 5;
    	this.arma = new Arma(TipoDeArmas.PUNHAL);
    	this.noPunhais = 4;
    }
    public Goblin(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
    
    @Override
    public void atacar(Combativel inimigo) {
        DadoCombate dado = new DadoCombate();
        if(noPunhais > 0) this.noPunhais--;
        int ataque = 0;
        for(int i = 0; i < this.dadosAtaque; i++) {
            if(dado.jogar() == Lado.CAVEIRA)
                ataque++;
        }
        if(noPunhais == 0) this.arma = new Arma(TipoDeArmas.PUNHO);
        inimigo.defender(ataque);
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
	public String toString(){
        return "Go";
    }
    
}
