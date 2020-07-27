package mc322.heroquest.mapa;

import mc322.heroquest.itens.MagiaDefensiva;
import mc322.heroquest.itens.MagiaOfensiva;

public abstract class HeroiMagico extends Heroi {

    protected HeroiMagico(String nome, Ponto posicao) {
    	super(nome, posicao);
    }
    //um heroi magico pode possuir no maximo 10 magias de defesa combate simultaneamente
    protected static int LIMITE_MAGIA = 10;
    protected MagiaOfensiva[] magiasOfensivas = new MagiaOfensiva[LIMITE_MAGIA];
    protected MagiaDefensiva[] magiasDefensivas = new MagiaDefensiva[LIMITE_MAGIA];
    
    @Override  //verifica se o heroi pode lancar magias
    public boolean eMagico() {
    	return false;
    }
    
    //verificacao se o heroi pode lancar magia no momento
    public boolean temMagiaOfensiva() {
    	if(magiasOfensivas[0] == null) return false;
    	return true;
    }
    
    public boolean temMagiaDefensiva() {
    	if(magiasDefensivas[0] == null) return false;
    	return true;
    }
    //quando lanca uma magia, as outras passam para frente nas opcoes
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
    //verifica se uma opcao de magia escolhida e valida
    public boolean eValido(int pos) {
    	if(this.magiasOfensivas[pos-1] == null) return false;
    	if(pos<0 || pos > LIMITE_MAGIA) {
    		return false;
    	}
    	return true;
    }
    //funcao de uso de magias. Apos o uso, a magia e descartada
    public void usarMagiaOfensiva(int pos, Monstro monstro) {
    	if(magiasOfensivas[pos-1].lancar(this, monstro))
    		arrumarMagiasOfensivas(pos-1);
    }
    
    public void usarMagiaDefensiva(int pos) {
    	magiasDefensivas[pos-1].lancar(this);
    	arrumarMagiasDefensivas(pos-1);
    }
    //retorna a string que mostra as opcoes de magia disponiveis
    public String verificaMagiasOfensivas() {
    	String resultado = "As magias disponíveis são:\n";
    	int i = 1;
    	for(MagiaOfensiva m : magiasOfensivas) {
    		resultado += i + ". " + m.getNome() + "\n";
    	}
    	return resultado;
    }
    
    public String verificaMagiasDefensivas() {
    	String resultado = "As magias disponíveis são:\n";
    	int i = 1;
    	for(MagiaDefensiva m : magiasDefensivas) {
    		resultado += i + ". " + m.getNome() + "\n";
    	}
    	return resultado;
    }

}
