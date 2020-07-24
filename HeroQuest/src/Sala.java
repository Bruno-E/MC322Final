package mc322.heroquest.main;

import java.util.List;
import java.util.ArrayList;

public class Sala {

    private int largura;
    private int altura;
    private Ponto coordenada;
    
    public Sala(Ponto coordenada, int largura, int altura) {
        this.coordenada = coordenada;
        this.largura = largura;
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }
    public int getAltura() {
        return altura;
    }
    public Ponto getCoordenada() {
        return coordenada;
    }


}
