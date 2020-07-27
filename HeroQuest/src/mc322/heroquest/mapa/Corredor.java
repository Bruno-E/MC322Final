package mc322.heroquest.mapa;

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
    
    // torna corredor visivel e chama varreLinhasColunasAteLimite
    // trata o caso do corredor com largura == 2
    public void setVisivel(boolean visivel, int linha, int coluna, Mapa mapa) {
        this.visivel = visivel;
        // Caso o corredor tenha largura 2
        if (this.coordenada.getColuna() == 12) {
        	this.setVisivel(visivel, linha, coluna + 1, mapa);
        }
        else if (this.coordenada.getColuna() == 13) {
        	this.setVisivel(visivel, linha, coluna - 1, mapa);
        }
        
        varreLinhasColunasAteLimite(linha, coluna, mapa);
    }
    public void setVisivel(boolean visivel, Ponto ponto, Mapa mapa) {
    	this.setVisivel(visivel, ponto.getLinha(), ponto.getColuna(), mapa);
    }
    
    
    // torna visiveis as linhas e colunas do corredor desde o ponto dado
    // ate os limites do corredor ou ate um obstaculo
    public void varreLinhasColunasAteLimite(int linha, int coluna, Mapa mapa) {
    	int varreLinha = linha,
    		varreColuna = coluna;
    	
    	// direcao Sul
        while(true) {
        	varreLinha++;
        	if (mapa.checarObstaculo(varreLinha, varreColuna)) break;
        	else if (mapa.foraDoMapa(varreLinha, varreColuna)) break;
        	else if (mapa.checarSala(varreLinha, varreColuna) != null) break;
        	else {
        		Elemento elemento = mapa.getElemento(varreLinha, varreColuna);
        		if (elemento != null)
        			elemento.setVisivel(true);
        	}
        }
        
        // direcao Norte
        varreLinha = linha;
	    varreColuna = coluna;
	    while(true) {
        	varreLinha--;
        	if (mapa.checarObstaculo(varreLinha, varreColuna)) break;
        	else if (mapa.foraDoMapa(varreLinha, varreColuna)) break;
        	else if (mapa.checarSala(varreLinha, varreColuna) != null) break;
        	else {
        		mapa.getElemento(varreLinha, varreColuna).setVisivel(true);
        	}
        }
	    
	    // direcao Leste
	    varreLinha = linha;
	    varreColuna = coluna;
	    while(true) {
        	varreColuna++;
        	if (mapa.checarObstaculo(varreLinha, varreColuna)) break;
        	else if (mapa.foraDoMapa(varreLinha, varreColuna)) break;
        	else if (mapa.checarSala(varreLinha, varreColuna) != null) break;
        	else {
        		mapa.getElemento(varreLinha, varreColuna).setVisivel(true);
        	}
        }
	    
	    // direcao Oeste
	    varreLinha = linha;
	    varreColuna = coluna;
	    while(true) {
        	varreColuna--;
        	if (mapa.checarObstaculo(varreLinha, varreColuna)) break;
        	else if (mapa.foraDoMapa(varreLinha, varreColuna)) break;
        	else if (mapa.checarSala(varreLinha, varreColuna) != null) break;
        	else {
        		mapa.getElemento(varreLinha, varreColuna).setVisivel(true);
        	}
        }
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

    // retorna true se o corredor contem o ponto
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
    public boolean contemPonto(int linha, int coluna) {
    	return contemPonto(new Ponto(linha, coluna));
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







