package mc322.heroquest.mapa;

import java.util.List;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.itens.Armadura;
import mc322.heroquest.itens.Item;
import mc322.heroquest.itens.Ouro;
import mc322.heroquest.itens.Pocao;
import mc322.heroquest.itens.TipoDeArmaduras;
import mc322.heroquest.itens.TipoDeArmas;
import mc322.heroquest.main.DadoCombate;
import mc322.heroquest.main.DadoVermelho;
import mc322.heroquest.main.Lado;

import java.util.ArrayList;

public abstract class Heroi extends ElementoCombate{
    protected String nome;
    protected int movimento;
    protected List<Item> mochila;
    protected int noPunhais;
    protected Arma[] ArmasAtuais = new Arma[2];
    protected int dadosMovimento = 2;
    protected int bonusAtaque = 0;
    protected int bonusDefesa = 0;
    protected int bonusMovimento = 0;
    protected Armadura armadura;
    protected Ouro ouro;

    protected Heroi(String nome, Ponto posicao) {
    	super(posicao, true);
        this.nome = nome;
        this.movimento = 0;
        this.noPunhais = 0;
        this.ArmasAtuais = new Arma[2];
        this.armadura = new Armadura(TipoDeArmaduras.NU);
        this.ouro = new Ouro(0);
    }
    
    public boolean addOuro(int valor) {
    	ouro.addValor(valor);
    	return true;
    }
    
    public Ponto getPosicao() {
    	return this.posicao;
    }
    //lancamento de dados para definir o numero de casas que o heroi ira andar no turno
    public int jogarDadosAndar() {
        DadoVermelho dado = new DadoVermelho();
        for(int i = 0; i < this.dadosMovimento + bonusMovimento; i++) {
        	movimento += dado.jogar();
        }
        if(bonusMovimento != 0) bonusMovimento = 0;
        movimento += dado.jogar();
        return this.movimento;
    }
    
    
    // muda a posicao do heroi caso seja possivel
    // TODO recebe dano de armadilha
    public void mover(String direcao, Mapa mapa) throws ParedeNoCaminhoException,
    													   ObstaculoNoCaminhoException 
    {    
        Ponto novaPosicao = this.posicao.novaPosicao(direcao);

        if (mapa.foraDoMapa(novaPosicao)) throw new ArrayIndexOutOfBoundsException("Nao pode sair do mapa.");
        
        Sala salaAtual = mapa.checarSala(posicao),
        	 salaNova = mapa.checarSala(novaPosicao);
        
        // o else é: ou permanece em corredores ou permanece em uma sala
        if (salaAtual != salaNova) {
	        if (salaAtual != null && !salaAtual.checarPorta(posicao, novaPosicao)) {
	        	if (salaNova != null) {
	        		if (!salaNova.checarPorta(posicao, novaPosicao))
	        		// vai de uma sala para outra e nenhuma tem a porta correspondente
	        		throw new ParedeNoCaminhoException();
	        	}
	        	// vai para um corredor mas nao tem a porta correspondente
	        	else throw new ParedeNoCaminhoException();
	        }
	        // vai para uma sala que nao possui a porta correspondente 
	        else if (salaAtual == null && salaNova != null && !salaNova.checarPorta(posicao, novaPosicao))
	    		throw new ParedeNoCaminhoException();
        }
        
     // Leva dano da armadilha caso haja
        Armadilha armadilha = mapa.checarArmadilha(novaPosicao);
        if (armadilha != null) {
        	armadilha.ativar(this);
        	mapa.removerElemento(armadilha);
        }
        
        if (mapa.checarObstaculo(novaPosicao)) throw new ObstaculoNoCaminhoException();

        else {
            mapa.removerElemento(this);
            // vai para a nova posicao
            this.setPosicao(novaPosicao);
            mapa.inserirElemento(this);
        }

    }
    
    
    protected void perdeVida(int dano) {
    	this.vida -= dano;
    }
    
    public boolean estaMorto() {
    	if(this.vida <= 0) return true;
    	return false;
    }
    
    public void trocarArmaPrincipal() {
    	Arma tmp = ArmasAtuais[0];
    	ArmasAtuais[0] = ArmasAtuais[1];
    	ArmasAtuais[1] = tmp;
    }
    
    public int getAlcance() {
    	return this.ArmasAtuais[0].getAlcance();
    }
    
    private void desequiparArma(TipoDeArmas arma) {
    	this.ArmasAtuais[0] = new Arma(arma);
    }
    
    @Override
    public void atacar(Combativel inimigo) {
        DadoCombate dado = new DadoCombate();
        if(this.ArmasAtuais[0].getInformation().contentEquals("Punhal")) {
        	this.noPunhais--;
        }
        int ataque = 0;
        for(int i = 0; i < this.dadosAtaque + bonusAtaque + ArmasAtuais[0].getBonus(); i++) {
            if(dado.jogar() == Lado.CAVEIRA)
                ataque++;
        }
        if(this.noPunhais == 0 && this.ArmasAtuais[0].getInformation().contentEquals("Punhal")) {
        	desequiparArma(TipoDeArmas.PUNHO);
        }
        if(bonusAtaque != 0) bonusAtaque = 0;
        inimigo.defender(ataque);
    }

    @Override
    public void defender(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.dadosDefesa + bonusDefesa + armadura.getBonus(); i++) {
          if(dado.jogar() == Lado.ESCUDO_HEROI)
              defesa++;
      }
      if(bonusDefesa != 0) bonusDefesa = 0;
      int resultado = ataque - defesa;
      if(resultado > 0) {
        perdeVida(resultado);
      }
    }
    
    public void setBonusAtaque(int bonus) {
    	this.bonusAtaque = bonus;
    }
    
    public void setBonusDefesa(int bonus) {
    	this.bonusDefesa = bonus;
    }
    
    public void setBonusMovimento(int bonus) {
    	this.bonusMovimento = bonus;
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

    
    public void vasculhar(Mapa mapa) {
    	
    	// Vasculha a sala
        Sala sala = mapa.checarSala(posicao);
        if(sala != null) {
        	sala.setVisivel(true);
        	Tesouro tesouro = sala.getTesouro();
        	if (tesouro != null) tesouro.abrirTesouro().coletar(this, mapa);
        	sala.removerTesouro();
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
        
        
        else {
	        int linha = this.getLinha(),
	        	coluna = this.getColuna();
	        ArrayList<Corredor> corredores = mapa.checarCorredor(linha, coluna);
	        
	        if(!corredores.isEmpty())
		        for (Corredor corr : corredores) {
		        	corr.setVisivel(true, posicao, mapa);
		        }
	    }
        
    }
    
    protected void arrumarMochila(int pos) {
    	for(int i = pos; i < mochila.size() - 1; i++) {
    		mochila.add(i, mochila.get(i+1));
    		mochila.add(i+1, null);
    	}
    }
    
    public String verificaMochila(String objeto) {
    	String resultado = "Voce possui as seguintes opcoes:";
    	int i = 1;
    	for(Item item : mochila) {
    		if(item.getInformation().contains(objeto)) {
    			resultado += i + ". " + item.getInformation() + "\n";
    		}
    		i++;
    	}
    	return resultado;
    }
    
    public boolean temDuasArmas() {
    	if(this.ArmasAtuais[1] == null) {
    		return false;
    	}
    	if(ArmasAtuais[0].equals(ArmasAtuais[1])) {
    		return false;
    	}
    	return true;
    }
    public boolean eMagico() {
    	return false;
    }
    public boolean temPocao() {
    	for(Item item : mochila) {
    		if(item.getInformation().contains("Pocao")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void usarPocao(int pos) {
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
    
    public boolean adcItem(Item item) {
    	boolean adicionou = false;
    	for(int i = 0; i < 10; i++) {
    		if(mochila.get(i) == null) {
    			mochila.add(i, item);
    			adicionou = true;
    		}
    	}
    	return adicionou;
    }

}
