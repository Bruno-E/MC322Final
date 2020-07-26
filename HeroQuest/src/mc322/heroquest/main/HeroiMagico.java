package mc322.heroquest.main;

public abstract class HeroiMagico extends Heroi {

    protected HeroiMagico(String nome, Ponto posicao) {
    	super(nome, posicao);
    }

    protected MagiaOfensiva[] magiasOfensivas = new MagiaOfensiva[10];
    protected MagiaDefensiva[] magiasDefensivas = new MagiaDefensiva[10];
    
    @Override 
    protected boolean eMagico() {
    	return false;
    }
    
    protected boolean temMagiaOfensiva() {
    	if(magiasOfensivas[0] == null) return false;
    	return true;
    }
    
    protected boolean temMagiaDefensiva() {
    	if(magiasDefensivas[0] == null) return false;
    	return true;
    }
    
    protected void arrumarMagiasOfensivas(int pos) {
    	for(int i = pos; i < magiasOfensivas.length - 1; i++) {
    		magiasOfensivas[i] = magiasOfensivas[i+1];
    		magiasOfensivas[i+1] = null;
    	}
    }
    
    protected void arrumarMagiasDefensivas(int pos) {
    	for(int i = pos; i < magiasDefensivas.length - 1; i++) {
    		magiasDefensivas[i] = magiasDefensivas[i+1];
    		magiasDefensivas[i+1] = null;
    	}
    }
    
    protected void usarMagiaOfensiva(int pos) {
    	magiasOfensivas[pos-1].lancar(this);
    	arrumarMagiasOfensivas(pos-1);
    }
    
    protected void usarMagiaDefensiva(int pos) {
    	magiasDefensivas[pos-1].lancar();
    	arrumarMagiasDefensivas(pos-1);
    }
    
    protected String verificaMagiasOfensivas() {
    	String resultado = "As magias disponíveis são:\n";
    	int i = 1;
    	for(MagiaOfensiva m : magiasOfensivas) {
    		resultado += i + ". " + m.getNome() + "\n";
    	}
    	return resultado;
    }
    
    protected String verificaMagiasDefensivas() {
    	String resultado = "As magias disponíveis são:\n";
    	int i = 1;
    	for(MagiaDefensiva m : magiasDefensivas) {
    		resultado += i + ". " + m.getNome() + "\n";
    	}
    	return resultado;
    }

}
