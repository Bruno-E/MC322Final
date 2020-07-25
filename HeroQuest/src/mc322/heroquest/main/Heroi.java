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

        if (!checarPorta(checarSala(mapa))) throw new ParedeNoCaminhoException();

        else if (saiDoMapa(direcao)) throw new ArrayIndexOutOfBoundsException("Nao pode sair do mapa.");

        else if (checarObstaculo(mapa)) throw new ObstaculoNoCaminhoException();

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
      for(int i = 0; i < this.bonusDefesa; i++) {
          if(dado.jogar() == Lado.ESCUDO_HEROI)
              defesa++;
      }
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
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
