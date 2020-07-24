package mc322.heroquest.main;

import java.util.*;

public class MissilMagico extends Magia {

    public MissilMagico() {
    }

    @Override
    protected void lancarMagia(Combativel origem, Combativel alvo) {
      DadoVermelho dado = new DadoVermelho();
      int valor = dado.jogar();
      if(valor < origem.getInteligencia()) {
        alvo.defesaMagica(6);
      }
    }

}
