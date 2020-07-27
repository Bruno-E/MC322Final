package mc322.heroquest.itens;

import mc322.heroquest.mapa.Coletavel;
import mc322.heroquest.mapa.Heroi;
import mc322.heroquest.mapa.Mapa;

public class Ouro extends Item implements Coletavel{   
    private int valor;
    
    public Ouro(int valor) {
    	this.nome = "Moedas de Ouro";
        this.valor=valor;
    }

    @Override
    public String getInformation(){
        return valor + " " + nome;
    }
    
    public void addValor(int soma) {
    	this.valor += soma;
    }
    
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	return heroi.addOuro(valor);
    }

}



