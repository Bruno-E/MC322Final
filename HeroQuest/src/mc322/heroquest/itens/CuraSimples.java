package mc322.heroquest.itens;

import mc322.heroquest.main.DadoVermelho;
import mc322.heroquest.mapa.ElementoCombate;

public class CuraSimples extends MagiaDefensiva {

    public CuraSimples() {
    	this.nome = "Cura Simples";
    }
    //simula um lancamento de dado pra verificar a quantidade de vida restaurada
   @Override
public void lancar(ElementoCombate origem) { //joga um dado para ver a quantidade de cura que o jogador/monstro recebe
	   DadoVermelho dado = new DadoVermelho();
	   origem.restauraVida(dado.jogar());
   }
}
