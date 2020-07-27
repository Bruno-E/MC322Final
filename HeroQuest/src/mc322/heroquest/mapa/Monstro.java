package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.main.DadoCombate;
import mc322.heroquest.main.Lado;

import java.util.Random;

public abstract class Monstro extends ElementoCombate implements Coletavel{

    public Monstro(Ponto posicao) {
    	super(posicao, false);
    }
    
    protected String nome;
    protected Arma arma;
    protected int movimento;

    @Override
    public void defender(int ataque) {
      DadoCombate dado = new DadoCombate();
      int defesa = 0;
      for(int i = 0; i < this.dadosDefesa; i++) {
          if(dado.jogar() == Lado.ESCUDO_MONSTRO)
              defesa++;
      }
      int resultado = ataque - defesa;
      if(resultado > 0) {
        this.vida -= resultado;
      }
    }
    
    public String getNome() {
    	return this.nome;
    }

    @Override
    public void defesaMagica(int ataque) {
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
    
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	return mapa.inserirMonstro(this);
    }
    
    
    // tenta andar 8 vezes ate desistir
    public void mover(Mapa mapa, Heroi heroi) {
    	if(this.visivel) {
    		
    		Random random = new Random();
    		int count = 0;
    		boolean andou = false;
    		do {
    			int noDirecao = random.nextInt(4);
	    		String direcao;
	    		switch (noDirecao) {
	    			case 0:
	    				direcao = "w";
	    				break;
	    			case 1:
	    				direcao = "a";
	    				break;
	    			case 2:
	    				direcao = "s";
	    				break;
	    			case 3:
	    				direcao = "d";
	    				break;
	    			default:
	    				direcao = "a";
	    		}
	    		Ponto novaPosicao = this.posicao.novaPosicao(direcao);
	
	            if (mapa.foraDoMapa(novaPosicao)) {
	            	count++;
	            	continue;
	            }
	            Sala salaAtual = mapa.checarSala(posicao),
	            	 salaNova = mapa.checarSala(novaPosicao);
	            
	            // o else é: ou permanece em corredores ou permanece em uma sala
	            if (salaAtual != salaNova) {
	    	        count++;
	    	        continue;
	            }
	    	     
	            else if (mapa.checarObstaculo(novaPosicao)) {
	            	count++;
	        		continue;
	            }

	            else {
	                mapa.removerElemento(this);
	                
	                // vai para a nova posicao
	                this.setPosicao(novaPosicao);
	                mapa.inserirElemento(this);
	                andou = true;
	            }
    		} while (!andou && count <= 8);
    	}
    }
    	

}







