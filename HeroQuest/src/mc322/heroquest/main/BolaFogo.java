package mc322.heroquest.main;

public class BolaFogo extends MagiaOfensiva {
	
	private static int danoAdjacente = 2;

    public BolaFogo() {
    	this.dano = 4;
    	this.nome = "Bola de Fogo";
    	this.alcance = 5;
    }
    
    @Override
    protected void lancar(Combativel origem, Combativel alvo) {
        DadoVermelho dado = new DadoVermelho();
        int valor = dado.jogar();
        if(valor < origem.getInteligencia()) {
          alvo.defesaMagica(dano);
          //TODO: verificaAdjacente - verifica as posicoes adjacentes se ha monstros
        }
        else {
        	System.out.println("Voce não conseguiu usar a magia");
        }
    }

}
