package mc322.heroquest.main;

import java.util.Random;

public abstract class Dado {

    public Dado() {
    }
    
    int aleatorio(int numLados){ //funcao comum que recebe o numero de lados de um dado e retorna a face
        Random valor = new Random();
        return valor.nextInt(numLados) + 1;
    }

}
