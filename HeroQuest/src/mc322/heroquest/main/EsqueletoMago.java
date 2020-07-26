package mc322.heroquest.main;

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
    
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }
    @Override 
    protected String toString(){
        return "EM"
    }

}
