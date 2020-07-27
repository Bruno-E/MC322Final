package mc322.heroquest.itens;

import mc322.heroquest.main.DadoVermelho;
import mc322.heroquest.mapa.Combativel;

public class MissilMagico extends MagiaOfensiva {

    public MissilMagico() {
    	this.dano = 6;
    	this.nome = "Missil Magico";
    	this.alcance = 5;
    }
    //verifica se quem lancou consegue tirar um dado menor que sua inteligencia
    //caso consiga, o alvo tera sua chance de defender do dano
    //caso nao consiga, a magia nao e lancada
    @Override
	public boolean lancar(Combativel origem, Combativel alvo) {
      DadoVermelho dado = new DadoVermelho();
      int valor = dado.jogar();
      if(valor < origem.getInteligencia()) {
        alvo.defesaMagica(dano);
        return true;
      }
      else {
      	System.out.println("Voce nao conseguiu usar a magia");
      }
      return false;
    }

}
