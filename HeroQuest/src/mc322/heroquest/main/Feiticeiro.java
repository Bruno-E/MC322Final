package mc322.heroquest.main;

public class Feiticeiro extends HeroiMagico {
    private static int VIDA_INICIAL = 4;
    private static int INT_INICIAL = 6;
    private static int ATQ_INICIAL = 1;
    private static int DFS_INICIAL = 2;
    
    private int noPunhais;

    public Feiticeiro(String nome, Ponto posicao) {
        super(nome, posicao);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.noPunhais = 3;
        this.ArmasAtuais[0] = new Arma(TipoDeArmas.PUNHAL);
        this.magiasOfensivas[0] = new MissilMagico();
        this.magiasOfensivas[1] = new MissilMagico();
        this.magiasOfensivas[2] = new MissilMagico();
        this.magiasOfensivas[3] = new BolaFogo();
        this.magiasDefensivas[0] = new Teleporte();
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
