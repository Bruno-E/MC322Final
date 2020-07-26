package mc322.heroquest.main;

public class Anao extends Heroi {
    private static int VIDA_INICIAL = 7;
    private static int INT_INICIAL = 3;
    private static int ATQ_INICIAL = 2;
    private static int DFS_INICIAL = 2;

    public Anao(String nome, Ponto posicao) {
        super(nome, posicao);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.ArmasAtuais[0] = new Arma(TipoDeArmas.ESPADA_CURTA);
    }
    public Anao(String nome, int linha, int coluna) {
    	this(nome, new Ponto(linha, coluna));
    }
    
    @Override
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
        return "An";
    }

}
