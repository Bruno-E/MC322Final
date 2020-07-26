package mc322.heroquest.main;

public class EsqueletoMago extends Monstro {

    public EsqueletoMago() {
    	this.vida = 3;
    	this.dadosAtaque = 1;
    	this.dadosDefesa = 1;
    	this.inteligencia = 3;
    	this.movimento = 3;
    	this.arma = new Arma(TipoDeArmas.PUNHO);
    }

    public MissilMagico missil;

}
