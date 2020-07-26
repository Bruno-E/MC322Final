package mc322.heroquest.main;

import java.util.Random;

public abstract class Dado {

    public Dado() {
    }
    
    int aleatorio(int numLados){
        Random valor = new Random();
        return valor.nextInt(numLados) + 1;
    }

}
