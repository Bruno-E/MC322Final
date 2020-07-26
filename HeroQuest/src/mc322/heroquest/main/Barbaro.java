package mc322.heroquest.main;

public class Barbaro extends Heroi {

    private static int VIDA_INICIAL = 8;
    private static int INT_INICIAL = 2;
    private static int ATQ_INICIAL = 3;
    private static int DFS_INICIAL = 2;

    public Barbaro(String nome, Ponto posicao) {
        super(nome, posicao);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.ArmasAtuais[0] = this.ArmasAtuais[1] = new Arma(TipoDeArmas.ESPADA_LONGA);
    }
    public Barbaro(String nome, int linha, int coluna) {
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
        return "Ba";
    }

}
