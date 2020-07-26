package mc322.heroquest.main;

public class CuraSimples extends MagiaDefensiva {

    CuraSimples() {
    	this.nome = "Cura Simples";
    }
    
   @Override
   protected void lancar(ElementoCombate origem) {
	   DadoVermelho dado = new DadoVermelho();
	   origem.restauraVida(dado.jogar());
   }
}
