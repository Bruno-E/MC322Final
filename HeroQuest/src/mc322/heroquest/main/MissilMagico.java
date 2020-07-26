package mc322.heroquest.main;

public class MissilMagico extends MagiaOfensiva {

    public MissilMagico() {
    	this.dano = 6;
    	this.nome = "Missil Magico";
    	this.alcance = 5;
    }

    @Override
    protected void lancar(Combativel origem, Combativel alvo) {
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
