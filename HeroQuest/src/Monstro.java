package mc322.heroquest.main;

import java.util.*;

public abstract class Monstro extends ElementoCombate {

    public Monstro() {
    }

    public Arma listaArma;

    @Override
    protected void defender(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.bonusDefesa; i++) {
          if(dado.jogar() == Lado.ESCUDO_MOSNTRO)
              defesa++;
      }
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
    }

    @Override
    protected void defesaMagica(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.inteligencia; i++) {
          if(dado.jogar() == Lado.ESCUDO_MONSTRO)
              defesa++;
      }
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
    }

}
