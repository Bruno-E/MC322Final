package mc322.heroquest.main;
import java.util.*;

public abstract class ElementoCombate extends Elemento implements Combativel {
  protected int vida;
  protected int inteligencia;
  protected int dadosAtaque;
  protected int dadosDefesa;

  @Override
  protected void atacar(Combativel inimigo) {
      DadoCombate dado = new DadoCombate();
      int ataque = 0;
      for(int i = 0; i < this.bonusAtaque; i++) {
          if(dado.jogar() == Lado.CAVEIRA)
              ataque++;
      }
      inimigo.defender(ataque);
  }
}
