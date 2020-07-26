package mc322.heroquest.main;

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
    
    void addValor(int soma) {
    	this.valor += soma;
    }
    
    public boolean coletar(Heroi heroi, Mapa mapa) {
    	return heroi.addOuro(valor);
    }

}



