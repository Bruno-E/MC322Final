package mc322.heroquest.mapa;

import mc322.heroquest.main.DadoCombate;
import mc322.heroquest.main.Lado;

public abstract class ElementoCombate extends Elemento implements Combativel {
  protected int vida;
  protected int inteligencia;
  protected int dadosAtaque;
  protected int dadosDefesa;
  
  public int getInteligencia() {
	  return this.inteligencia;
  }
  
  protected ElementoCombate(Ponto posicao, boolean visivel) {
	  super(posicao, visivel);
  }

  public void atacar(Combativel inimigo) {
      DadoCombate dado = new DadoCombate();
      int ataque = 0;
      for(int i = 0; i < this.dadosAtaque; i++) {
          if(dado.jogar() == Lado.CAVEIRA)
              ataque++;
      }
      inimigo.defender(ataque);
  }
  
}

