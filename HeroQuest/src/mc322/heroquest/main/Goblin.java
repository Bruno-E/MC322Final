package mc322.heroquest.main;

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
    
    
    public void restauraVida(int vida) {
    	if(this.vida + vida > VIDA_INICIAL) {
    		this.vida = VIDA_INICIAL;
    	}
    	else {
    		this.vida += vida;
    	}
    }
    
    @Override
    public void mover(Mapa mapa, Heroi heroi) {
    	if (visivel) {
	    	String direcao = null;
	    	int linha = this.getLinha(),
	    		coluna = this.getColuna();
	    	
	    	int diffLinha = linha - heroi.getLinha(),
	    		diffColuna = coluna - heroi.getColuna();
	    	
	    	// a maior distancia eh na vertical
	    	if (Math.abs(diffLinha) > Math.abs(diffColuna)) {
	    		
	    		// diferenca positiva se tem que ir para Norte
	    		if (diffLinha > 1) direcao = "w";
	    		else if (diffLinha < -1) direcao = "s";
	    	}
	    	// maior distancia na horizontal
	    	else if (Math.abs(diffLinha) < Math.abs(diffColuna)) {
	    		
	    		// diferenca positiva se tem que ir para Oeste
	    		if (diffColuna > 1) direcao = "a";
	    		else if (diffColuna < -1) direcao = "d";
	    	}
	    	// adjacente
	    	else if (Math.abs(diffLinha) == 1 ||  Math.abs(diffColuna) == 1) return;
	    	
	    	// uma direcao qualquer
	    	if(direcao == null) direcao = "d";
	    	
	    	// corredores
	    	/*
	    	else if (coluna == 0 || coluna == 12 || coluna == 13 || coluna == 25) {
	    		if (linha >= 0 && linha <= 5) direcao = "s";
	    		else if (linha >= 13 && linha <= 18) direcao = "w";
	    	}
	    	else if (linha == 0 || linha == 9 || linha == 18) {
	    		if (coluna >= 0 && coluna <= 8) direcao = "d";
	    		else if (coluna >= 17 && coluna <= 25) direcao = "a";
	    	}
	    	*/
	    	
	    	Ponto novaPosicao = this.posicao.novaPosicao(direcao);
	    	
	        if (mapa.foraDoMapa(novaPosicao)) return;
	        
	        Sala salaAtual = mapa.checarSala(posicao),
	        	 salaNova = mapa.checarSala(novaPosicao);
	        
	        // o else é: ou permanece em corredores ou permanece em uma sala
	        if (salaAtual != salaNova) return;
		     
	        else if (mapa.checarObstaculo(novaPosicao)) return;
	
	        else {
	            mapa.removerElemento(this);
	            
	            // vai para a nova posicao
	            this.setPosicao(novaPosicao);
	            mapa.inserirElemento(this);
	        }
	    }
    }
    
    
    @Override
	public String toString(){
        return "Go";
    }
    
}










