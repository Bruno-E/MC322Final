package mc322.heroquest.mapa;

import mc322.heroquest.itens.Arma;
import mc322.heroquest.main.DadoCombate;
import mc322.heroquest.main.Lado;

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
    
    public void mover(Heroi heroi) {
    	
    }
    	

}
