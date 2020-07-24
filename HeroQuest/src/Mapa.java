package mc322.heroquest.main;

import java.util.List;
import java.util.ArrayList;

public class Mapa {
    
    private Elemento[][] elementos;
    private List<Monstro> monstros;
    private Sala[] arraySalas;
    
    // Coordenadas linha x coluna do ponto mais acima e a esquerda da sala
    private static final int[][] coordSalas = 
    { 
      {1, 1}, {1, 5}, {1, 9}, {1, 14}, {1, 17}, {1, 21},
      {4, 1}, {4, 5}, {5, 17}, {5, 21}, {7, 10},
      {10, 1}, {10, 15}, {10, 7}, {10, 17}, {10, 21},
      {13, 5}, {13, 9}, {13, 14}, {14, 1}, {14, 17}, {14, 21},
    };

    // Dimensoes largura x altura de cada sala
    private static final int[][] dimSalas = 
    { 
      {4, 3}, {4, 3}, {3, 5}, {3, 5}, {4, 4}, {4, 4},
      {4, 5}, {4, 5}, {4, 4}, {4, 4}, {6, 5},
      {4, 4}, {2, 3}, {2, 3}, {4, 4}, {4, 4},
      {4, 5}, {3, 5}, {3, 5}, {4, 4}, {4, 4}, {4, 4},
    };
    
    private static final int linhas = 19, colunas = 26, noSalas = 22;

    public Mapa() {
        //Array 2D de elementos
        elementos = new Elemento[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            elementos[i] = new Elemento[colunas];
        }

        //Lista de monstros
        monstros = new ArrayList<Monstro>();

        arraySalas = new Sala[noSalas];
        for (int i = 0; i < noSalas; i++) {
            linha = coordSalas[i][0];
            coluna = coordSalas[i][1];
            largura = dimSalas[i][0];
            altura = dimSalas[i][1];
            coordenada = new Ponto(linha, coluna);
            
            arraySalas[i] = new Sala(coordenada, largura, altura);
            
            //TODO Colocar elementos no mapa
        }
        
    }

    public boolean inserirElemento(Elemento elemento) {
        linha = elemento.posicao().getLinha();
        coluna = elemento.posicao().getColuna();
        if (elementos[linha][coluna] == null) {
            elementos[linha][coluna] = elemento;
            return true;
        }
        else return false;
    }

    public boolean removerElemento(int linha, int coluna) {
        if (elementos[linha][coluna] != null) {
            elementos[linha][coluna] = null;
            return true;
        }
        else return false;
    }

    public boolean removerElemento(Elemento elemento) {
        linha = elemento.posicao().getLinha();
        coluna = elemento.posicao().getColuna();
        if (elementos[linha][coluna] == elemento) {
            return removerElemento(linha, coluna);
        }
        else return false;
    }

}
