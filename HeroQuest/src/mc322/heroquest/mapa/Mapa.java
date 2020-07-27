package mc322.heroquest.mapa;

import java.util.List;
import java.util.ArrayList;

public class Mapa {
    
    private Elemento[][] elementos;
    private List<Monstro> monstros;
    private List<Armadilha> armadilhas;
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
    
    
    // retorna a sala correspondente a ordem da lista
    public Sala getSala(int noSala) {
    	return salas[noSala];
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
    
    
    public boolean haMonstros() {
    	return monstros.isEmpty();
    }
    
    
    // retorna um monstro se houver e se for visivel
    private Monstro checarMonstro(int linha, int coluna) {
        for (Monstro monstro : monstros) {
            if (monstro.getLinha() == linha && monstro.getColuna() == coluna)
            	if(monstro.getVisivel()) return monstro;
        }
        return null;
    }
    private Monstro checarMonstro(Ponto ponto) {
    	int linha = ponto.getLinha(),
    		coluna = ponto .getColuna();
    	return checarMonstro(linha, coluna);
    }
    
    
    // retorna uma armadilha se houver e se for visivel
    public Armadilha checarArmadilha(int linha, int coluna) {
        for (Armadilha armadilha : armadilhas) {
            if (armadilha.getLinha() == linha && armadilha.getColuna() == coluna)
            	return armadilha;
        }
        return null;
    }
    public Armadilha checarArmadilha(Ponto ponto) {
    	return checarArmadilha(ponto.getLinha(), ponto .getColuna());
    }
    
    
    // retorna um ArrayList dos monstros ao alcance do ponto dado
    public ArrayList<Monstro> monstrosAoAlcance(Ponto ponto, int alcance) {
    	ArrayList<Monstro> monstros = new ArrayList<Monstro>();
    	int linha = ponto.getLinha(),
        	coluna = ponto .getColuna();
    	
    	for(int i = linha - alcance; i <= linha + alcance; i++) {
    		for(int j = coluna - alcance; j <= coluna + alcance; j++) {
   				if(!foraDoMapa(i, j))
   					if(checarSala(ponto) == checarSala(i, j) && ponto.aoAlcance(i, j, alcance)) {
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
    
    // Deve ser usado sempre que uma armadilha eh inserida!!!
    // retorna false se não inseriu
    public boolean inserirArmadilha(Armadilha armadilha) {
        if (armadilhas == null) armadilhas = new ArrayList<Armadilha>();
        
        if(inserirElemento(armadilha)) {
        	armadilhas.add(armadilha);
            return true;
        }
        else return false;
    }

    // retorna false se nao ha elementos no ponto
    public boolean removerElemento(int linha, int coluna) {
    	Armadilha armadilha = checarArmadilha(linha, coluna);
        if (armadilha != null) armadilhas.remove(armadilha);
    	
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

    
    // Levar em conta que o inserirMonstro() retorna false
    public void atualizarMonstros(Heroi heroi) {
        if(!monstros.isEmpty())
        	for (Monstro monstro : monstros)
        		monstro.mover(this, heroi);
    }
    
    
    // Os monstros atacam se forem visiveis e o heroi estiver ao alcance
    public void monstrosAtacam(Heroi heroi) {
    	if (!monstros.isEmpty()) {
    		for (Monstro monstro : monstros)
    			monstro.atacar(heroi);
    	}
    }
    
    
    public void tornarVisivel(int linha, int coluna) {
    	Armadilha armadilha = checarArmadilha(linha, coluna);
        if (armadilha != null) armadilha.setVisivel(true);

        Monstro monstro = checarMonstro(linha, coluna);
        if (monstro != null) monstro.setVisivel(true);

        // else porque o monstro eh o mesmo objeto, caso esteja presente
        else if (elementos[linha][coluna] != null) {
            elementos[linha][coluna].setVisivel(true);
        }
    }
    
    public void construirBusca3() {
    	
    	// Obstaculos
    	Obstaculo obstaculo  = new Obstaculo(1, 0);
    	this.inserirObstaculo(obstaculo);
    	
	//sempre repete
	obstaculo = new Obstaculo(10, 0);
	this.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 7);
	this.inserirObstaculo(obstaculo);
	    
    	//Armadilhas
	Armadilha armadilha= new ArmadilhaFlecha(11,8);
	this.inserirArmadilha(armadilha);
	    
    	// Goblins
    	Goblin goblin = new Goblin(2, 2);
    	this.inserirMonstro(goblin);
    	
	// sempre repete
	goblin = new Goblin(11, 5);
	this.inserirMonstro(goblin);

	goblin = new Goblin(15, 6);
	this.inserirMonstro(goblin);
    	
    	// Esqueleto
    	Esqueleto esqueleto = new Esqueleto(7, 4);
    	this.inserirMonstro(esqueleto);
    	
	// sempre repete
	esqueleto = new Esqueleto(12, 2);
	this.inserirMonstro(esqueleto);

	esqueleto = new Esqueleto(15, 1);
	this.inserirMonstro(esqueleto);
    	
    	// EsqueletoMago
    	EsqueletoMago esqueletoMago = new EsqueletoMago(7, 4);
    	this.inserirMonstro(esqueletoMago);
    	
    	// Portas
    	Ponto ponto0 = new Ponto(2, 0), 
    		  ponto1 = new Ponto(2, 1);

    	Porta porta = new Porta(ponto0, ponto1);
    	
    	int noSala = 0;
    	Sala sala = this.getSala(noSala);
    	
    	sala.adicionarPorta(porta);
    	
	// sempre repete
	ponto0 = new Ponto(4, 8); 
	ponto1 = new Ponto(4, 9);
	noSala = 2;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 4); 
	ponto1 = new Ponto(8, 5);
	noSala = 6;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 2); 
	ponto1 = new Ponto(9, 2);
	noSala = 6;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(9, 5); 
	ponto1 = new Ponto(10, 5);
	noSala = 12;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 4); 
	ponto1 = new Ponto(12, 5);
	noSala = 11;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 8); 
	ponto1 = new Ponto(13, 8);
	noSala = 13;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando tesouro nesta sala
	Tesouro tesouro= new Tesouro(10,8);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(13, 2); 
	ponto1 = new Ponto(14, 2);
	noSala = 19;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(16, 4); 
	ponto1 = new Ponto(16, 5);
	noSala = 19;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

    }
    
    
    public void construirBusca2() {
    	
    	// Obstaculos
    	Obstaculo obstaculo  = new Obstaculo(5,12);
    	this.inserirObstaculo(obstaculo);

	//sempre repete
	obstaculo = new Obstaculo(5, 13);
	this.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 1);
	this.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 24);
	this.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(18, 9);
	this.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(18,14);
	this.inserirObstaculo(obstaculo);
	
	//Armadilhas
	Armadilha armadilha= new ArmadilhaFlecha(13,2);
	this.inserirArmadilha(armadilha);
    	
    	// Goblins
    	Goblin goblin = new Goblin(15,10);
    	this.inserirMonstro(goblin);

	// sempre repete
	goblin = new Goblin(15,8);
	this.inserirMonstro(goblin);

	goblin = new Goblin(3,15);
	this.inserirMonstro(goblin);
    	
    	// Esqueleto
    	Esqueleto esqueleto = new Esqueleto(12, 2);
    	this.inserirMonstro(esqueleto);

	// sempre repete
	esqueleto = new Esqueleto(7,19);
	this.inserirMonstro(esqueleto);

	esqueleto = new Esqueleto(6,23);
	this.inserirMonstro(esqueleto);
    	
    	// EsqueletoMago
    	EsqueletoMago esqueletoMago = new EsqueletoMago(11, 8);
    	this.inserirMonstro(esqueletoMago);
    	
    	// Portas
    	Ponto ponto0 = new Ponto(5,15), 
    	ponto1 = new Ponto(6,15);

    	Porta porta = new Porta(ponto0, ponto1);
    	
    	int noSala = 3;
    	Sala sala = this.getSala(noSala);
    	
    	sala.adicionarPorta(porta);

	// sempre repete
	ponto0 = new Ponto(8,23); 
	ponto1 = new Ponto(9,23);
	noSala = 9;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(11,10); 
	ponto1 = new Ponto(12,10);
	noSala = 10;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(9, 2); 
	ponto1 = new Ponto(10, 2);
	noSala = 11;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(17,11); 
	ponto1 = new Ponto(18, 11);
	noSala = 17;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 15); 
	ponto1 = new Ponto(9, 15);
	noSala = 16;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 8); 
	ponto1 = new Ponto(13, 8);
	noSala = 13;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(6,20); 
	ponto1 = new Ponto(6,21);
	noSala =8;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando um tesouro nessa sala
	Tesouro tesouro= new Tesouro(8,19);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(11,6); 
	ponto1 = new Ponto(11,7);
	noSala = 12;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando um tesouro nesta sala
	tesouro= new Tesouro(11,5);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(4,19); 
	ponto1 = new Ponto(5,19);
	noSala = 4;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(3,16); 
	ponto1 = new Ponto(3,17);
	noSala = 4;
	porta = new Porta(ponto0, ponto1);
	sala = this.getSala(noSala);
	sala.adicionarPorta(porta);

    }
    
    
    public void construirBusca13() {
    	
    	//Obstaculos
    	Obstaculo obstaculo = new Obstaculo(7,0);
    	this.inserirObstaculo(obstaculo);       	
    	
    	obstaculo = new Obstaculo(11,0);
    	this.inserirObstaculo(obstaculo);    	
    	
    	obstaculo = new Obstaculo(9,6);
    	this.inserirObstaculo(obstaculo);  	
    	
    	obstaculo = new Obstaculo(9,20);
    	this.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(18,1);
    	this.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(18,24);
    	this.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(5,12);
    	this.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(5,13);
    	this.inserirObstaculo(obstaculo);
	    
	//Armadilhas
	ArmadilhaFlecha armadilha= new ArmadilhaFlecha(9,0);
	this.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(11,9);
	this.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(6,11);
	this.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(6,14);
	this.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(14,12);
	this.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(9,19);
	this.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(17,20);
	this.inserirArmadilha(armadilha);
    	
    	//goblins
    	Goblin goblin = new Goblin(11,3);
    	this.inserirMonstro(goblin);
    	
    	goblin = new Goblin(13,12);
    	this.inserirMonstro(goblin);
    	
    	goblin = new Goblin(13,13);
    	this.inserirMonstro(goblin);
    	
    	//esqueleto
    	Esqueleto esqueleto = new Esqueleto(16,1);
    	this.inserirMonstro(esqueleto);
    	
    	esqueleto = new Esqueleto(17,20);
    	this.inserirMonstro(esqueleto);
    	
    	esqueleto = new Esqueleto(16,22);
    	this.inserirMonstro(esqueleto);
    	
    	//esqueleto mago
    	EsqueletoMago esqueletomago = new EsqueletoMago(15,22);
    	this.inserirMonstro(esqueletomago);
    	
    	//portas e tesouros
    	Ponto ponto1 = new Ponto(9,2), ponto2 = new Ponto(10,2);
    	Porta porta = new Porta(ponto1, ponto2);    	
    	int noSala = 11;
    	Sala sala = this.getSala(11);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,7);
    	ponto2 = new Ponto(10,7);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 13;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,9);
    	ponto2 = new Ponto(9,10);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,15);
    	ponto2 = new Ponto(9,16);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(6,12);
    	ponto2 = new Ponto(7,12);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(11,12);
    	ponto2 = new Ponto(12,12);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,19);
    	ponto2 = new Ponto(8,19);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 8;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,3);
    	ponto2 = new Ponto(18,3);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(11,4);
    	ponto2 = new Ponto(11,5);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 12;
    	Tesouro tesouro = new Tesouro(11,6); 	
    	sala = this.getSala(noSala);
    	sala.adicionarTesouro(tesouro);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(13,2);
    	ponto2 = new Ponto(14,2);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,3);
    	ponto2 = new Ponto(18,3);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,4);
    	ponto2 = new Ponto(17,5);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 16;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(18,22);
    	ponto2 = new Ponto(17,22);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 21;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(18,19);
    	ponto2 = new Ponto(17,19);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 20;
    	sala = this.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    }
    
    public Mapa construirAleatoio() {
    	Mapa mapa = new Mapa();
    	
    	//TODO Construir mapa correspondente
    	
    	return mapa;
    }

}
