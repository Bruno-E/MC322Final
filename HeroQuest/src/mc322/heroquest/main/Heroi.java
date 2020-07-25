package mc322.heroquest.main;

public abstract class Heroi extends ElementoCombate{
    protected String nome;
    protected int movimento;
    protected Item[] mochila;
    protected Arma[] ArmasAtuais;
    protected int bonusAtaque;
    protected int bonusDefesa;
    protected int bonusMovimento;

    protected Heroi(String nome) {
        this.nome = nome;
        this.movimento = 0;
        this.ArmasAtuais = new Arma[2];
    }

    protected int jogarDadosAndar() {
        DadoVermelho dado = new DadoVermelho();
        movimento += dado.jogar();
        movimento += dado.jogar();
        return this.movimento;
    }

    protected void mover(char direcao, Mapa mapa) {

        // TODO Sala checarSala(Mapa mapa) retorna uma sala se o movimento leva para dentro dela
        // TODO boolean checarPorta(Sala sala) retorna true se o movimento ocorre em uma porta
        // TODO boolean saiDoMapa(char direcao)
        // TODO public class ParedeNoCaminhoException extends Exception {}
        // TODO public class ObstaculoNoCaminhoException extends Exception {}
        // TODO public class Obstaculo {}

        // TODO Printar mensagem das exceções no try-catch de mover() no Game.java

        if (!checarPorta(checarSala(mapa))) throw new ParedeNoCaminhoException("Parede no caminho.");

        else if (saiDoMapa(direcao)) throw new ArrayIndexOutOfBoundsException("Nao pode sair do mapa.");

        else if (checarObstaculo(mapa)) throw new ObstaculoNoCaminhoException("Obstaculo no caminho");

        else {
            mapa.removerElemento(this);
            switch(direcao) {
                // TODO funcoes moverPara<direção>()
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
      for(int i = 0; i < this.bonusDefesa; i++) {
          if(dado.jogar() == Lado.ESCUDO_HEROI)
              defesa++;
      }
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
        String conteudo="O conteudo da mochila �:";
        for(Item item : mochila)
            conteudo+=" "+item.getInformation();
        System.out.println(conteudo);
    }

}
