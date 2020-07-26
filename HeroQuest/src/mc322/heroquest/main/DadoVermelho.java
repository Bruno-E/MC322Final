package mc322.heroquest.main;

public class DadoVermelho extends Dado {

    public DadoVermelho() {
    }

    public int jogar() { //age como um dado comum de 6 faces, retornando um valor de 1 a 6
        return aleatorio(6);
    }

}
