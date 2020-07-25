package mc322.heroquest.main;

import java.util.List;

public abstract class Heroi extends ElementoCombate{
    protected String nome;
    protected int movimento;
    protected List<Item> mochila;
    protected Arma[] ArmasAtuais = new Arma[2];
    protected int dadosMovimento = 2;
    protected int bonusAtaque = 0;
    protected int bonusDefesa = 0;
    protected int bonusMovimento = 0;

    protected Heroi(String nome, Ponto posicao) {
    	super(posicao);
        this.nome = nome;
        this.movimento = 0;
        this.ArmasAtuais = new Arma[2];
    }

    protected int jogarDadosAndar() {
        DadoVermelho dado = new DadoVermelho();
        for(int i = 0; i < this.dadosMovimento + bonusMovimento; i++) {
        	movimento += dado.jogar();
        }
        if(bonusMovimento != 0) bonusMovimento = 0;
        movimento += dado.jogar();
        return this.movimento;
    }

    private Ponto novaPosicao(String direcao) {
        switch(direcao) {
            case "w":
                return new Ponto(this.getLinha() - 1, this.getColuna());
                break;
            case "a":
                return new Ponto(this.getLinha(), this.getColuna() - 1);
                break;
            case "s":
                return new Ponto(this.getLinha() + 1, this.getColuna());
                break;
            case "d":
                return new Ponto(this.getLinha(), this.getColuna() + 1);
                break;
        }
        return null;
    }

    protected void mover(String direcao, Mapa mapa) {
        
        Ponto novaPosicao = novaPosicao(direcao);

        if (mapa.foraDoMapa(novaPosicao)) throw new ArrayIndexOutOfBoundsException("Nao pode sair do mapa.");

        Sala sala = mapa.checarSala(posicao);
        if (sala == null) sala = mapa.checarSala(novaPosicao);
        if (sala != null) {
            if (!sala.checarPorta(posicao, novaPosicao)) throw new ParedeNoCaminhoException();
        }

        else if (mapa.checarObstaculo(novaPosicao)) throw new ObstaculoNoCaminhoException();

        else {
            mapa.removerElemento(this);
            this.setPosicao(novaPosicao);
            mapa.inserirElemento(this);
        }

    }
    
    @Override
    public void atacar(Combativel inimigo) {
        DadoCombate dado = new DadoCombate();
        int ataque = 0;
        for(int i = 0; i < this.dadosAtaque + bonusAtaque; i++) {
            if(dado.jogar() == Lado.CAVEIRA)
                ataque++;
        }
        if(bonusAtaque != 0) bonusAtaque = 0;
        inimigo.defender(ataque);
    }

    @Override
    public void defender(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.dadosDefesa + bonusDefesa; i++) {
          if(dado.jogar() == Lado.ESCUDO_HEROI)
              defesa++;
      }
      if(bonusDefesa != 0) bonusDefesa = 0;
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
    }
    
    protected void setBonusAtaque(int bonus) {
    	this.bonusAtaque = bonus;
    }
    
    protected void setBonusDefesa(int bonus) {
    	this.bonusDefesa = bonus;
    }
    
    protected void setBonusMovimento(int bonus) {
    	this.bonusMovimento = bonus;
    }
      
    protected void restauraVida(int vida) {
    	
    }

    @Override
    public void defesaMagica(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.inteligencia; i++) {
          if(dado.jogar() == Lado.ESCUDO_HEROI)
              defesa++;
      }
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
    }

    // Vasculha a sala
    protected void vasculhar(Mapa mapa) {
        Sala sala = mapa.checarSala(posicao);
        if(sala != null) {
            int[] limites = sala.getLimitesSupInfEsqDir();
            int linhaSuperior = limites[0],
                linhaInferior = limites[1],
                colunaEsquerda = limites[2],
                colunaDireita = limites[3];
                
            for(int i = linhaSuperior; i <= linhaInferior; i++) {
                for(int j = colunaEsquerda; j <= colunaDireita; j++) {
                    mapa.tornarVisivel(i, j);
                }
            }
        }
        // TODO else: tem como vasculhar o corredor?
        // Em caso afirmativo, implementar usando foraDoMapa() e checarSala() para um certo range
        
    }
    
    protected void arrumarMochila(int pos) {
    	for(int i = pos; i < mochila.size() - 1; i++) {
    		mochila.add(i, mochila.get(i+1));
    	}
    }
    
    protected String verificaMochila(String objeto) {
    	String resultado = "Você possui as seguintes opcoes:";
    	int i = 0;
    	for(Item item : mochila) {
    		if(item.getInformation().contains(objeto)) {
    			resultado += (i+1) + ". " + item.getInformation() + "\n";
    		}
    		i++;
    	}
    	return resultado;
    }
    
    protected boolean temPocao() {
    	for(Item item : mochila) {
    		if(item.getInformation().contains("Pocao")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    protected void usarPocao(int pos) {
    	((Pocao)mochila.get(pos-1)).usar(this);
    	mochila.add(pos-1, null);
    	arrumarMochila(pos-1);
    }

    protected void verMochila() {
        String conteudo = "O conteudo da mochila eh:";
        for(Item item : mochila)
            conteudo += " " + item.getInformation();
        System.out.println(conteudo);
    }

}
