package mc322.heroquest.main;

public class CuraSimples extends MagiaDefensiva {

    CuraSimples() {
    	this.nome = "Cura Simples";
    }
    
   @Override
   protected void lancar(ElementoCombate origem) { //joga um dado para ver a quantidade de cura que o jogador/monstro recebe
	   DadoVermelho dado = new DadoVermelho();
	   origem.restauraVida(dado.jogar());
   }
}
