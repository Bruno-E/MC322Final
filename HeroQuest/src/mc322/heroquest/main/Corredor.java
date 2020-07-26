package mc322.heroquest.main;

import java.util.List;
import java.util.ArrayList;

public class Corredor {
	
    private int largura;
    private int altura;
    private boolean visivel;
    private Ponto coordenada;
    private List<Obstaculo> obstaculos;
    
    public Corredor(Ponto coordenada, int largura, int altura) {
        this.coordenada = coordenada;
        this.largura = largura;
        this.altura = altura;
        obstaculos = new ArrayList<Obstaculo>();
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
    
    
    public boolean inserirObstaculo(Obstaculo obstaculo) {
    	if (checarObstaculo(obstaculo.getPosicao()) == null) {
    		obstaculos.add(obstaculo);
    		return true;
    	}
    	else return false;
    }
    
    
    public Obstaculo checarObstaculo(int linha, int coluna) {
    	if (!obstaculos.isEmpty()) {
	    	for (Obstaculo obstaculo : obstaculos) {
	    		if (obstaculo.getLinha() == linha && obstaculo.getColuna() == coluna)
	    			return obstaculo;
	    	}
	    }
    	return null;
    }
    public Obstaculo checarObstaculo(Ponto ponto) {
    	return checarObstaculo(ponto.getLinha(), ponto.getColuna());
    }

}







