package mc322.heroquest.main;

import java.util.List;
import java.util.ArrayList;

public class Sala {

    private int largura;
    private int altura;
    private boolean visivel;
    private Ponto coordenada;
    private List<Porta> portas;
    
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
    
    public boolean getVisivel() {
    	return visivel;
    }
    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    // retorna true se os pontos da porta sao iguais aos de alguma da lista
    public boolean checarPorta(Ponto ponto0, Ponto ponto1) {
        for(Porta porta : portas) {
            Ponto[] pontos = porta.getPontos();
            if (pontos[0].equals(ponto0)) {
                if (pontos[1].equals(ponto1)) return true;
            }
            else if (pontos[1].equals(ponto0)) {
                if (pontos[0].equals(ponto1)) return true;
            }        
        }
        return false;
    }
    public boolean checarPorta(Porta porta) {
        Ponto[] pontos = porta.getPontos();
        return checarPorta(pontos[0], pontos[1]);
    }
    

    // Retorna int[] : 0. linhaSuperior
    //                 1. linhaInferior
    //                 2. colunaEsquerda
    //                 2. colunaDireita
    public int[] getLimitesSupInfEsqDir() {
        int[] limites = new int[4];
        limites[0] = coordenada.getLinha();
        limites[1] = limites[0] + (altura - 1);
        limites[2] = coordenada.getColuna();
        limites[3] = limites[2] + (largura - 1);
        return limites;
    }

    // retorna true se a sala contem o ponto
    public boolean contemPonto(Ponto ponto) {
        int[] limites = getLimitesSupInfEsqDir();
        int linhaSuperior = limites[0],
            linhaInferior = limites[1],
            colunaEsquerda = limites[2],
            colunaDireita = limites[3];

        for(int i = linhaSuperior; i <= linhaInferior; i++) {
            for(int j = colunaEsquerda; j <= colunaDireita; j++) {
                if (ponto.getLinha() == i && ponto.getColuna() == j) return true;
            }
        }
        return false;
    }

    public boolean adicionarPorta(Porta porta){
        if (portas == null) portas = new ArrayList<Porta>();
        if (this.checarPorta(porta)) return false;
        else {
        	portas.add(porta);
        	return true;
        }
    }

}

