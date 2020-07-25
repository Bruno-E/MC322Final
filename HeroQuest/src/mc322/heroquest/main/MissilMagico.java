package mc322.heroquest.main;

import java.util.*;

public class MissilMagico extends MagiaOfensiva {

    public MissilMagico() {
    	this.dano = 6;
    }

    @Override
    protected void lancarMagia(Combativel origem, Combativel alvo) {
      DadoVermelho dado = new DadoVermelho();
      int valor = dado.jogar();
      if(valor < origem.getInteligencia()) {
        alvo.defesaMagica(dano);
      }
      else {
      	System.out.println("Voce não conseguiu usar a magia");
      }
    }

}
