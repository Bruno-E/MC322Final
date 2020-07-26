package mc322.heroquest.main;

public abstract class Monstro extends ElementoCombate implements Guardavel{

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
    
    String getNome() {
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
    
    public void coletar(Heroi heroi) {
    	
    }
    
    protected void mover() {
    	
    }

}
