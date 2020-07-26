package mc322.heroquest.main;

import java.util.List;
import java.util.ArrayList;

public class Mapa {
    
    private Elemento[][] elementos;
    private List<Monstro> monstros;
    private Sala[] salas;
    private Corredor[] corredores;
    
    // Coordenadas linha x coluna do ponto mais acima e a esquerda da sala
    private static final int[][] coordSalas = 
    { 
    	{1, 1}, {1, 5}, {1, 9}, {1, 14}, {1, 17}, {1, 21},
    	{4, 1}, {4, 5}, {5, 17}, {5, 21}, {7, 10},
    	{10, 1}, {10, 15}, {10, 7}, {10, 17}, {10, 21},
    	{13, 5}, {13, 9}, {13, 14}, {14, 1}, {14, 17}, {14, 21}
    };

    // Dimensoes largura x altura de cada sala
    private static final int[][] dimSalas = 
    { 
    	{4, 3}, {4, 3}, {3, 5}, {3, 5}, {4, 4}, {4, 4},
    	{4, 5}, {4, 5}, {4, 4}, {4, 4}, {6, 5},
    	{4, 4}, {2, 3}, {2, 3}, {4, 4}, {4, 4},
    	{4, 5}, {3, 5}, {3, 5}, {4, 4}, {4, 4}, {4, 4}
    };
    
    
    // Coordenadas linha x coluna do ponto mais acima e a esquerda de cada corredor
    private static final int[][] coordCorredores = 
    {
    	{0, 0}, {0, 0}, {0, 25}, {18, 0}, {0, 12}, {9, 0},
    	{9, 16}, {12, 12}, {6, 9}, {6, 9}, {6, 16}, {12, 9}
    };
    
    // Dimensoes largura x altura de cada corredor
    private static final int[][] dimCorredores = 
    {
    	{26, 1}, {1, 19}, {1, 19}, {26, 1}, {2, 7}, {10, 1},
    	{10, 1}, {2, 7}, {8, 1}, {1, 7}, {1, 7}, {8, 1}
    };
    
    private static final int linhas = 19, colunas = 26, noSalas = 22, noCorredores = 12;

    public Mapa() {
        //Array 2D de elementos
        elementos = new Elemento[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            elementos[i] = new Elemento[colunas];
        }

        //Lista de monstros
        monstros = new ArrayList<Monstro>();

        // inicializa salas
        salas = new Sala[noSalas];
        for (int i = 0; i < noSalas; i++) {
            int linha = coordSalas[i][0],
                coluna = coordSalas[i][1],
                largura = dimSalas[i][0],
                altura = dimSalas[i][1];
            Ponto coordenada = new Ponto(linha, coluna);
            
            salas[i] = new Sala(coordenada, largura, altura);
        }
        
     // inicializa corredores
        corredores = new Corredor[noCorredores];
        for (int i = 0; i < noCorredores; i++) {
            int linha = coordCorredores[i][0],
                coluna = coordCorredores[i][1],
                largura = dimCorredores[i][0],
                altura = dimCorredores[i][1];
            Ponto coordenada = new Ponto(linha, coluna);
            
            corredores[i] = new Corredor(coordenada, largura, altura);
        }
        
    }

    // retorna uma sala se o ponto esta dentro dela
    public Sala checarSala(Ponto ponto) {
        for(int i = 0; i < noSalas; i++) {
            if (salas[i].contemPonto(ponto)) {
                return salas[i];
            }
        }
        return null;
    }
    public Sala checarSala(int linha, int coluna) {
    	Ponto ponto = new Ponto(linha, coluna);
    	return checarSala(ponto);
    }
    
    
    // retorna uma lista dos corredores que contem o ponto
    public ArrayList<Corredor> checarCorredor(Ponto ponto) {
    	ArrayList<Corredor> listaMatch = new ArrayList<Corredor>();
 
        for(int i = 0; i < noCorredores; i++) {
            if (corredores[i].contemPonto(ponto)) {
                listaMatch.add(corredores[i]);
            }
        }
        return listaMatch;
    }
    public ArrayList<Corredor> checarCorredor(int linha, int coluna) {
    	Ponto ponto = new Ponto(linha, coluna);
    	return checarCorredor(ponto);
    }
    
    
    // retorna true se ha obstaculo
    public boolean checarObstaculo(Ponto ponto) {
    	if (getElemento(ponto) == null) return false;
    	else return true;
    }
	public boolean checarObstaculo(int linha, int coluna) {
	    	Ponto ponto = new Ponto(linha, coluna);
	    	return checarObstaculo(ponto);
	}
    

    // retorna true se o ponto esta fora do mapa
    public boolean foraDoMapa(Ponto ponto) {
        if ( ponto.getLinha() < 0 || ponto.getLinha() >= linhas || 
            ponto.getColuna() < 0 || ponto.getColuna() >= colunas)
            return true;
        else 
            return false;
    }
    public boolean foraDoMapa(int linha, int coluna) {
    	Ponto ponto = new Ponto(linha, coluna);
    	return foraDoMapa(ponto);
    }
    
    
    // retorna um monstro se houver e se for visivel
    public Monstro checarMonstro(int linha, int coluna) {
        for (Monstro monstro : monstros) {
            if (monstro.getLinha() == linha && monstro.getColuna() == coluna)
            	if(monstro.getVisivel()) return monstro;
        }
        return null;
    }
    public Monstro checarMonstro(Ponto ponto) {
    	int linha = ponto.getLinha(),
    		coluna = ponto .getColuna();
    	return checarMonstro(linha, coluna);
    }
    
    // retorna um ArrayList dos monstros ao alcance do ponto dado
    public ArrayList<Monstro> monstrosAoAlcance(Ponto ponto, int alcance) {
    	ArrayList<Monstro> monstros = new ArrayList<Monstro>();
    	int linha = ponto.getLinha(),
        	coluna = ponto .getColuna();
    	
    	for(int i = linha - alcance; i <= linha + alcance; i++) {
    		for(int j = coluna - alcance; j <= coluna + alcance; j++) {
   				if(!foraDoMapa(i, j))
   					if(checarSala(i, j) == null) {
   						Monstro monstro = checarMonstro(i, j);
   						if (monstro != null) monstros.add(monstro);
   					}
    		}
    	}
    	
    	return monstros;
    }

    public Elemento getElemento(int linha, int coluna) {
        Monstro monstro = checarMonstro(linha, coluna);
        if (monstro != null) return monstro;
        return (elementos[linha][coluna]);
    }
    public Elemento getElemento(Ponto ponto) {
        return getElemento(ponto.getLinha(), ponto.getColuna());
    }

    // retorna false se nao conseguir inserir o elemento
    public boolean inserirElemento(Elemento elemento) {
        int linha = elemento.getLinha(),
            coluna = elemento.getColuna();
        
        Sala sala = checarSala(elemento.getPosicao());
        if (sala != null) elemento.setVisivel(sala.getVisivel());
        
        ArrayList<Corredor> corredores = checarCorredor(elemento.getPosicao());
        if (!corredores.isEmpty())
        	for (Corredor corr : corredores) {
        		if (corr.getVisivel()) {
        			elemento.setVisivel(true);
        			break;
        		}
        		else elemento.setVisivel(false);
        	}
        
        if (elementos[linha][coluna] == null) {
            elementos[linha][coluna] = elemento;
            return true;
        }
        else return false;
    }
    
    // retorna false se nao conseguir inserir o obstaculo
    public boolean inserirObstaculo(Obstaculo obstaculo) {
        int linha = obstaculo.getPosicao().getLinha(),
            coluna = obstaculo.getPosicao().getColuna();
        ArrayList<Corredor> matchCorredor = checarCorredor(obstaculo.getPosicao());
        
        if (elementos[linha][coluna] == null && !matchCorredor.isEmpty()) {
	            elementos[linha][coluna] = obstaculo;
	            for(Corredor corr : matchCorredor)
	            	corr.inserirObstaculo(obstaculo);
	            return true;
        	}
        else return false;
    }
    
    
    // Deve ser usado sempre que um monstro eh inserido!!!
    // Tambem usado para mover o monstro
    public boolean inserirMonstro(Monstro monstro) {
        if (monstros == null) monstros = new ArrayList<Monstro>();
        
        if(inserirElemento(monstro)) {
            monstros.add(monstro);
            return true;
        }
        else return false;
        
    }

    // retorna false se nao ha elementos no ponto
    public boolean removerElemento(int linha, int coluna) {
        Monstro monstro = checarMonstro(linha, coluna);
        if (monstro != null) monstros.remove(monstro);
        
        if (elementos[linha][coluna] != null) {
            elementos[linha][coluna] = null;
            return true;
        }
        else return false;
    }

    public boolean removerElemento(Ponto ponto) {
        return removerElemento(ponto.getLinha(), ponto.getColuna());
    }

    // retorna false se o elemento nao esta no mapa
    public boolean removerElemento(Elemento elemento) {
        int linha = elemento.getPosicao().getLinha(),
            coluna = elemento.getPosicao().getColuna();
        if (elementos[linha][coluna] == elemento) {
            return removerElemento(linha, coluna);
        }
        else return false;
    }

    // TODO Goblins andam em direcao ao heroi, os outros aleatoriamente
    // Levar em conta que o inserirMonstro() retorna false
    public void atualizarMonstros(Heroi heroi) {
        
    }
    
    public void tornarVisivel(int linha, int coluna) {
        Monstro monstro = checarMonstro(linha, coluna);
        if (monstro != null) monstro.setVisivel(true);

        // else porque o monstro eh o mesmo objeto, caso esteja presente
        else if (elementos[linha][coluna] != null) {
            elementos[linha][coluna].setVisivel(true);
        }
    }

}
