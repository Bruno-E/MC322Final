package mc322.heroquest.main;

public class Ouro extends Item {   
    private int valor;
    
    public Ouro(int valor) {
    	this.nome = "Moedas de Ouro";
        this.valor=valor;
    }

    @Override
    public String getInformation(){
        return valor + " " + nome;
    }

}
