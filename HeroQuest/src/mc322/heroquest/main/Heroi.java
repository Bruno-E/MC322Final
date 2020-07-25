package mc322.heroquest.main;

public abstract class Heroi extends ElementoCombate{
    protected String nome;
    protected int movimento;
    protected Item[] mochila;
    protected Arma[] ArmasAtuais;
    protected int dadosMovimento = 2;
    protected int bonusAtaque = 0;
    protected int bonusDefesa = 0;
    protected int bonusMovimento = 0;

    protected Heroi(String nome) {
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

    protected void mover(char direcao, Mapa mapa) {

        if (!checarPorta(mapa.checarSala(posicao, direcao))) throw new ParedeNoCaminhoException();

        else if (mapa.saiDoMapa(posicao, direcao)) throw new ArrayIndexOutOfBoundsException("Nao pode sair do mapa.");

        else if (mapa.checarObstaculo(posicao, direcao)) throw new ObstaculoNoCaminhoException();

        else {
            mapa.removerElemento(this);
            switch(direcao) {
                case "w":
                    moverParaCima();
                    break;
                case "a":
                    moverParaEsquerda();
                    break;
                case "s":
                    moverParaBaixo();
                    break;
                case "d":
                    moverParaDireita();
                    break;
            }
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

    private void moverParaCima() {
        this.setPosicao(this.getLinha()--, this.getColuna())
    }
    private void moverParaBaixo() {
        this.setPosicao(this.getLinha()++, this.getColuna())
    }
    private void moverParaEsquerda() {
        this.setPosicao(this.getLinha(), this.getColuna()--)
    }
    private void moverParaDireita() {
        this.setPosicao(this.getLinha(), this.getColuna()++)
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

    protected void vasculhar() {
        // TODO implement here
    }

    protected void verMochila() {
        String conteudo = "O conteudo da mochila eh:";
        for(Item item : mochila)
            conteudo += " " + item.getInformation();
        System.out.println(conteudo);
    }

}
