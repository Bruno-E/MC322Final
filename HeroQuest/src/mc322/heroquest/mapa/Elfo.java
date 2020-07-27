package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.itens.CuraSimples;
import mc322.heroquest.itens.TipoDeArmas;

public class Elfo extends HeroiMagico {

    private static int VIDA_INICIAL = 6;
    private static int INT_INICIAL = 4;
    private static int ATQ_INICIAL = 2;
    private static int DFS_INICIAL = 2;

    public Elfo(String nome, Ponto posicao) {
        super(nome, posicao);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.magiasDefensivas[0] = new CuraSimples();
        this.ArmasAtuais[0] = new Arma(TipoDeArmas.ESPADA_CURTA);
    }
    public Elfo(String nome, int linha, int coluna) {
    	this(nome, new Ponto(linha, coluna));
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
        return "El";
    }

}
