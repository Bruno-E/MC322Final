package mc322.heroquest.main;

import java.util.Random;

public abstract class Dado {
	//um dado ira sempre possuir a funcao aleatorio para representar um lancamento comum
	//retorando um valor que corresponde ao valor tirado pelo jogador
    public Dado() {
    }
    
    int aleatorio(int numLados){ //funcao comum que recebe o numero de lados de um dado e retorna a face
        Random valor = new Random();
        return valor.nextInt(numLados) + 1;
    }

}
