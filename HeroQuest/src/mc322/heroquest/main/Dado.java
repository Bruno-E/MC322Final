package mc322.heroquest.main;

public abstract class Dado {

    public Dado() {
    }
    
    public int aleatorio(int numLados){
        Random valor = new Random();
        return valor.nextInt(numLados) + 1;
    }

}
