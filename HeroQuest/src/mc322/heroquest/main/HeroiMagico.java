package mc322.heroquest.main;

public abstract class HeroiMagico extends Heroi {

    protected HeroiMagico(String nome, Ponto posicao) {
    	super(nome, posicao);
    }

    protected Magia[] magias = new Magia[10];
    
    @Override 
    protected boolean eMagico() {
    	return false;
    }
    
    protected void arrumarMagias(int pos) {
    	for(int i = pos; i < magias.length - 1; i++) {
    		magias[i] = magias[i+1];
    		magias[i+1] = null;
    	}
    }
    
    protected void usarMagia(int pos) {
    	magias[pos-1].lancar();
    	arrumarMagias(pos-1);
    }
    protected String verificaMagias() {
    	String resultado = "As magias disponíveis são:\n";
    	int i = 1;
    	for(Magia m : magias) {
    		resultado += i + ". " + m.getNome() + "\n";
    	}
    	return resultado;
    }

}
