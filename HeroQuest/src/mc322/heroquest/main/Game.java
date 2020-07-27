package mc322.heroquest.main;

import java.util.ArrayList;
import java.util.Scanner;

import mc322.heroquest.mapa.Anao;
import mc322.heroquest.mapa.Armadilha;
import mc322.heroquest.mapa.ArmadilhaFlecha;
import mc322.heroquest.mapa.Barbaro;
import mc322.heroquest.mapa.Elfo;
import mc322.heroquest.mapa.Esqueleto;
import mc322.heroquest.mapa.EsqueletoMago;
import mc322.heroquest.mapa.Feiticeiro;
import mc322.heroquest.mapa.Goblin;
import mc322.heroquest.mapa.Heroi;
import mc322.heroquest.mapa.HeroiMagico;
import mc322.heroquest.mapa.Mapa;
import mc322.heroquest.mapa.Monstro;
import mc322.heroquest.mapa.Obstaculo;
import mc322.heroquest.mapa.ObstaculoNoCaminhoException;
import mc322.heroquest.mapa.ParedeNoCaminhoException;
import mc322.heroquest.mapa.Ponto;
import mc322.heroquest.mapa.Porta;
import mc322.heroquest.mapa.Sala;
import mc322.heroquest.mapa.Tesouro;

public class Game {
    private boolean fim;

    public Game() {
      fim = false;
    }
    
    //TODO Construir mapa correspondente
    private Mapa construirBusca3() {
    	Mapa mapa = new Mapa();
    	
    	// Obstaculos
    	Obstaculo obstaculo  = new Obstaculo(1, 0);
    	mapa.inserirObstaculo(obstaculo);
    	
	//sempre repete
	obstaculo = new Obstaculo(10, 0);
	mapa.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 7);
	mapa.inserirObstaculo(obstaculo);
	    
    	//Armadilhas
	Armadilha armadilha= new ArmadilhaFlecha(11,8);
	mapa.inserirArmadilha(armadilha);
	    
    	// Goblins
    	Goblin goblin = new Goblin(2, 2);
    	mapa.inserirMonstro(goblin);
    	
	// sempre repete
	goblin = new Goblin(11, 5);
	mapa.inserirMonstro(goblin);

	goblin = new Goblin(15, 6);
	mapa.inserirMonstro(goblin);
    	
    	// Esqueleto
    	Esqueleto esqueleto = new Esqueleto(7, 4);
    	mapa.inserirMonstro(esqueleto);
    	
	// sempre repete
	esqueleto = new Esqueleto(12, 2);
	mapa.inserirMonstro(esqueleto);

	esqueleto = new Esqueleto(15, 1);
	mapa.inserirMonstro(esqueleto);
    	
    	// EsqueletoMago
    	EsqueletoMago esqueletoMago = new EsqueletoMago(7, 4);
    	mapa.inserirMonstro(esqueletoMago);
    	
    	// Portas
    	Ponto ponto0 = new Ponto(2, 0), 
    		  ponto1 = new Ponto(2, 1);

    	Porta porta = new Porta(ponto0, ponto1);
    	
    	int noSala = 0;
    	Sala sala = mapa.getSala(noSala);
    	
    	sala.adicionarPorta(porta);
    	
	// sempre repete
	ponto0 = new Ponto(4, 8); 
	ponto1 = new Ponto(4, 9);
	noSala = 2;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 4); 
	ponto1 = new Ponto(8, 5);
	noSala = 6;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 2); 
	ponto1 = new Ponto(9, 2);
	noSala = 6;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(9, 5); 
	ponto1 = new Ponto(10, 5);
	noSala = 12;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 4); 
	ponto1 = new Ponto(12, 5);
	noSala = 11;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 8); 
	ponto1 = new Ponto(13, 8);
	noSala = 13;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando tesouro nesta sala
	Tesouro tesouro= new Tesouro(10,8);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(13, 2); 
	ponto1 = new Ponto(14, 2);
	noSala = 19;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(16, 4); 
	ponto1 = new Ponto(16, 5);
	noSala = 19;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);
    	
    	return mapa;
    }
    
    
    private Mapa construirBusca2() {
	Mapa mapa = new Mapa();
    	
    	// Obstaculos
    	Obstaculo obstaculo  = new Obstaculo(5,12);
    	mapa.inserirObstaculo(obstaculo);

	//sempre repete
	obstaculo = new Obstaculo(5, 13);
	mapa.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 1);
	mapa.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(9, 24);
	mapa.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(18, 9);
	mapa.inserirObstaculo(obstaculo);

	obstaculo = new Obstaculo(18,14);
	mapa.inserirObstaculo(obstaculo);
	
	//Armadilhas
	Armadilha armadilha= new ArmadilhaFlecha(13,2);
	mapa.inserirArmadilha(armadilha);
    	
    	// Goblins
    	Goblin goblin = new Goblin(15,10);
    	mapa.inserirMonstro(goblin);

	// sempre repete
	goblin = new Goblin(15,8);
	mapa.inserirMonstro(goblin);

	goblin = new Goblin(3,15);
	mapa.inserirMonstro(goblin);
    	
    	// Esqueleto
    	Esqueleto esqueleto = new Esqueleto(12, 2);
    	mapa.inserirMonstro(esqueleto);

	// sempre repete
	esqueleto = new Esqueleto(7,19);
	mapa.inserirMonstro(esqueleto);

	esqueleto = new Esqueleto(6,23);
	mapa.inserirMonstro(esqueleto);
    	
    	// EsqueletoMago
    	EsqueletoMago esqueletoMago = new EsqueletoMago(11, 8);
    	mapa.inserirMonstro(esqueletoMago);
    	
    	// Portas
    	Ponto ponto0 = new Ponto(5,15), 
    	ponto1 = new Ponto(6,15);

    	Porta porta = new Porta(ponto0, ponto1);
    	
    	int noSala = 3;
    	Sala sala = mapa.getSala(noSala);
    	
    	sala.adicionarPorta(porta);

	// sempre repete
	ponto0 = new Ponto(8,23); 
	ponto1 = new Ponto(9,23);
	noSala = 9;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(11,10); 
	ponto1 = new Ponto(12,10);
	noSala = 10;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(9, 2); 
	ponto1 = new Ponto(10, 2);
	noSala = 11;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(17,11); 
	ponto1 = new Ponto(18, 11);
	noSala = 17;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(8, 15); 
	ponto1 = new Ponto(9, 15);
	noSala = 16;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(12, 8); 
	ponto1 = new Ponto(13, 8);
	noSala = 13;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(6,20); 
	ponto1 = new Ponto(6,21);
	noSala =8;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando um tesouro nessa sala
	Tesouro tesouro= new Tesouro(8,19);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(11,6); 
	ponto1 = new Ponto(11,7);
	noSala = 12;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);
	//colocando um tesouro nesta sala
	tesouro= new Tesouro(11,5);
	sala.adicionarTesouro(tesouro);

	ponto0 = new Ponto(4,19); 
	ponto1 = new Ponto(5,19);
	noSala = 4;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);

	ponto0 = new Ponto(3,16); 
	ponto1 = new Ponto(3,17);
	noSala = 4;
	porta = new Porta(ponto0, ponto1);
	sala = mapa.getSala(noSala);
	sala.adicionarPorta(porta);
    	
    	return mapa;
    }
    
    
    private Mapa construirBusca13() {
    	Mapa mapa = new Mapa();
    	
    	//Obstaculos
    	Obstaculo obstaculo = new Obstaculo(7,0);
    	mapa.inserirObstaculo(obstaculo);       	
    	
    	obstaculo = new Obstaculo(11,0);
    	mapa.inserirObstaculo(obstaculo);    	
    	
    	obstaculo = new Obstaculo(9,6);
    	mapa.inserirObstaculo(obstaculo);  	
    	
    	obstaculo = new Obstaculo(9,20);
    	mapa.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(18,1);
    	mapa.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(18,24);
    	mapa.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(5,12);
    	mapa.inserirObstaculo(obstaculo);
    	
    	obstaculo = new Obstaculo(5,13);
    	mapa.inserirObstaculo(obstaculo);
	    
	//Armadilhas
	ArmadilhaFlecha armadilha= new ArmadilhaFlecha(9,0);
	mapa.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(11,9);
	mapa.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(6,11);
	mapa.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(6,14);
	mapa.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(14,12);
	mapa.inserirArmadilha(armadilha);
	    
	armadilha= new ArmadilhaFlecha(9,19);
	mapa.inserirArmadilha(armadilha);
	
	armadilha= new ArmadilhaFlecha(17,20);
	mapa.inserirArmadilha(armadilha);
    	
    	//goblins
    	Goblin goblin = new Goblin(11,3);
    	mapa.inserirMonstro(goblin);
    	
    	goblin = new Goblin(13,12);
    	mapa.inserirMonstro(goblin);
    	
    	goblin = new Goblin(13,13);
    	mapa.inserirMonstro(goblin);
    	
    	//esqueleto
    	Esqueleto esqueleto = new Esqueleto(16,1);
    	mapa.inserirMonstro(esqueleto);
    	
    	esqueleto = new Esqueleto(17,20);
    	mapa.inserirMonstro(esqueleto);
    	
    	esqueleto = new Esqueleto(16,22);
    	mapa.inserirMonstro(esqueleto);
    	
    	//esqueleto mago
    	EsqueletoMago esqueletomago = new EsqueletoMago(15,22);
    	mapa.inserirMonstro(esqueletomago);
    	
    	//portas e tesouros
    	Ponto ponto1 = new Ponto(9,2), ponto2 = new Ponto(10,2);
    	Porta porta = new Porta(ponto1, ponto2);    	
    	int noSala = 11;
    	Sala sala = mapa.getSala(11);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,7);
    	ponto2 = new Ponto(10,7);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 13;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,9);
    	ponto2 = new Ponto(9,10);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,15);
    	ponto2 = new Ponto(9,16);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(6,12);
    	ponto2 = new Ponto(7,12);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(11,12);
    	ponto2 = new Ponto(12,12);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 10;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(9,19);
    	ponto2 = new Ponto(8,19);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 8;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,3);
    	ponto2 = new Ponto(18,3);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(11,4);
    	ponto2 = new Ponto(11,5);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 12;
    	Tesouro tesouro = new Tesouro(11,6); 	
    	sala = mapa.getSala(noSala);
    	sala.adicionarTesouro(tesouro);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(13,2);
    	ponto2 = new Ponto(14,2);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,3);
    	ponto2 = new Ponto(18,3);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 19;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(17,4);
    	ponto2 = new Ponto(17,5);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 16;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(18,22);
    	ponto2 = new Ponto(17,22);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 21;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	ponto1 = new Ponto(18,19);
    	ponto2 = new Ponto(17,19);
    	porta = new Porta(ponto1, ponto2);
    	noSala = 20;
    	sala = mapa.getSala(noSala);
    	sala.adicionarPorta(porta);
    	
    	return mapa;
    }
    
    
    private Mapa construirAleatoio() {
    	Mapa mapa = new Mapa();
    	
    	//TODO Construir mapa correspondente
    	
    	return mapa;
    }
    

    public void start() {
        System.out.println("Jogo iniciado.");
        Scanner key = new Scanner(System.in);
        Heroi personagem = new Anao("Default", 0, 0);
        
        System.out.println("Qual sera o nome do seu personagem?");
        String nome = key.nextLine();
        
        System.out.println("Qual sera sua classe (Digite o numero): 1.Anao, 2.Barbaro, 3.Elfo, 4.Feiticeiro.");
        int classe = -1;
        Ponto pontoInicial = new Ponto(0, 0);
        do{
        	classe = key.nextInt();
        	if(classe == 1) {
        		personagem = new Anao(nome, pontoInicial);
        	}
        	else if(classe == 2) {
        		personagem = new Barbaro(nome, pontoInicial);
        	}
        	else if(classe == 3) {
        		personagem = new Elfo(nome, pontoInicial);
        	}
        	else if(classe == 4) {
        		personagem = new Feiticeiro(nome, pontoInicial);
        	}
        } while(classe > 4 || classe < 1);
        
        
        System.out.println("Digite o numero correspondente ao mapa que deseja:" +
        				   "\n(1. Busca 3, 2. Busca 2, 3. Busca 13, 42. aleatorio)");
        int noMapa;
        Mapa mapa = new Mapa();
        boolean inputCorreto = false;
        do {
        	noMapa = key.nextInt();
        	switch (noMapa) {
        		case 1:
        			mapa = construirBusca3();
        			inputCorreto = true;
        			// posicao inicial
        			personagem.setPosicao(1, 11);
        			break;
        		case 2:
        			mapa = construirBusca2();
        			inputCorreto = true;
        			//TODO posicao inicial no mapa
        			personagem.setPosicao(9, 10);
        			break;
        		case 3:
        			mapa = construirBusca13();
        			inputCorreto = true;
        			//TODO posicao inicial no mapa
        			personagem.setPosicao(9, 14);
        			break;
        		case 42:
        			mapa = construirAleatoio();
        			inputCorreto = true;
        			//TODO posicao inicial no mapa
        			personagem.setPosicao(linha, coluna);
        			break;
        		default:
        			System.out.println("Entrada invalida.");
        			break;
        	}
        	
        } while(!inputCorreto);
        
        
        while(!fim) {

            /* printar mapa
             * System.out.println(mapa);
        	*/
            lerInput(personagem, mapa);
            mapa.atualizarMonstros(personagem);
            if(personagem.estaMorto() || !mapa.haMonstros()) fim = true;

        }
        System.out.println("Fim de jogo. Ate logo!");
    }

    public void lerInput(Heroi personagem, Mapa mapa) {
        int movimento = personagem.jogarDadosAndar();
        System.out.println("Voce pode andar " + movimento + " casas esse turno.");

        Scanner keyboard = new Scanner (System.in);
        boolean acaoDisponivel = true;
        boolean podeAndar = true;
        boolean passar = false;

        while (!passar && (acaoDisponivel || podeAndar) ) {
            System.out.println("Digite um dos seguintes comandos: \"w-a-s-d\" caso queira andar, \"acao\" caso queira tomar alguma acao com seu personagem ou \"passar\" para passar para a proxima rodada.") ;
            String comando = keyboard.nextLine() ;

            switch(comando) {
                case "w":
                case "a":
                case "s":
                case "d":
                    try {
                        personagem.mover(comando, mapa);
                    } //parede array obstaculo
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    catch(ParedeNoCaminhoException e) {
                        System.err.println(e.getMessage());
                    }
                    catch(ObstaculoNoCaminhoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                    
                case "passar":
                    passar = true;
                    break;
                    
                case "acao":
                    if(!acaoDisponivel) {
                        System.out.println("Voce nao pode realizar uma acao agora.");
                        break;
                    }
                    else {
                        System.out.println("Escolha uma acao entre : atacar (a), usar magia (s), tomar pocao (q), procurar (f)");
                        String acao;  
                        boolean checagem = false;
                        Scanner input = new Scanner(System.in);
                        Monstro monstro;
                        int opcao;
                        do {
                        	acao = keyboard.nextLine();
                        	switch(acao) {
                            	case "a":
                            		
                            		if(personagem.temDuasArmas()) {
                            			System.out.println("Escolha qual arma voce pretende usar(1 ou 2)");
                            			do {
                            			opcao = input.nextInt();
                            			}while(opcao != 1 && opcao != 2);
                            			if(opcao == 2) personagem.trocarArmaPrincipal();
                            		}
                            		
                            		System.out.println("Seu alcance é: " + personagem.getAlcance() );
                            		
                            		ArrayList<Monstro> monstros= mapa.monstrosAoAlcance(personagem.getPosicao(), personagem.getAlcance());
                        			System.out.println("Os monstros no alcance sao:\n");
                        			int j = 1;
                        			for(Monstro m : monstros) {
                        				System.out.println(j + ". " + m.getNome() + "\n");
                        				j++;
                        			}
                        			
                        			monstro = monstros.get(0);
                            		System.out.println("Digite o numero do seu alvo.");
                        			do {
                        				opcao = input.nextInt();
                        				try {
                        					monstro = monstros.get(opcao-1);
                        					checagem = true;
                        				}
                        				catch(IndexOutOfBoundsException e) {
                        					System.out.print("Opcao invalida.");
                        				}
                        			}while(!checagem);
                            		
                        			personagem.atacar(monstro);
                            		break;
                            	
                            	case "s":
                            		if(!personagem.eMagico()) {
                            			System.out.println("Voce nao pode lancar magias.");
                            			break;
                            		}
                            		System.out.println("Voce deseja lancar uma magia defensiva (1) ou ofensiva(2)?");
                            		
                            		do {
                            			opcao = input.nextInt();
                            			if(opcao != 1 && opcao != 2) {
                            				System.out.println("Opcao invalida. Digite 1 para magias defensivas ou 2 para magias ofensivas.");
                            			}
                            		}while(opcao != 1 && opcao != 2);
                            		
                            		if(opcao == 1) {
                            			
                            			if(!((HeroiMagico)personagem).temMagiaDefensiva()) {
                                			System.out.println("Nao ha magias defensivas disponiveis");
                                			continue;
                            			}
                            			
                            			System.out.print(((HeroiMagico)personagem).verificaMagiasDefensivas());
                            			System.out.println("Digite o numero da magia desejada.");
                                		
                            			do {
                                			opcao = input.nextInt();
                                			try {
                                				((HeroiMagico)personagem).usarMagiaDefensiva(opcao);
                                				checagem = true;
                                			}
                                			catch(NullPointerException e) {
                                				System.out.println("Opcao invalida. Digite uma das opcoes sugeridas.");
                                			}
                                			catch(ArrayIndexOutOfBoundsException e) {
                                				System.out.println("Opcao invalida. Digite uma das opcoes sugeridas.");
                                			}
                                		}while(!checagem); 			
                            		}
                            		
                            		else {
                            			if(!((HeroiMagico)personagem).temMagiaOfensiva()) {
                                			System.out.println("Nao ha magias ofensivas disponiveis");
                                			continue;
                            			}
                                		System.out.print(((HeroiMagico)personagem).verificaMagiasOfensivas());
                            			System.out.println("Digite o numero da magia desejada.");
                            			int magia;
                            			
                            			do {
                            				opcao = input.nextInt();
                            				magia = opcao;
                            				if(((HeroiMagico)personagem).eValido(magia));
                            					checagem = true;                           				
                            			}while(!checagem);
                            			
                            			ArrayList<Monstro> monstros1= mapa.monstrosAoAlcance(personagem.getPosicao(), 5);
                           			
                            			int i = 1;
                            			System.out.println("Os monstros no alcance sao:\n");
                            			for(Monstro m : monstros1) {
                            				System.out.println(i + ". " + m.getNome() + "\n");
                            				i++;
                            			}
                            			
                            			monstro = monstros1.get(0);
                            			System.out.println("Escolha o monstro desejado.");
                            			do {
                            				opcao = input.nextInt();
                            				try {
                            					monstro = monstros1.get(opcao-1);
                            					checagem = true;
                            				}
                            				catch(IndexOutOfBoundsException e) {
                            					System.out.print("Opcao invalida.");
                            				}
                            			}while(!checagem);
                                		
                            			((HeroiMagico)personagem).usarMagiaOfensiva(magia, monstro);

                            		}
//
                            		acaoDisponivel = false;
                            		break;		                            		
                            	case "q":
                            		if(personagem.temPocao()) {
                            			System.out.print(personagem.verificaMochila("Pocao"));
                            			System.out.println("Digite o numero da pocao desejada.");
                            			boolean valido = false;
                            			do {
                            				opcao = input.nextInt();
                            				try {
                            					personagem.usarPocao(opcao);
                            					valido = true;
                            				}
                            				catch(ClassCastException e) {
                            					System.out.println("Opcao invalida. Digite uma das opcoes sugeridas.");
                            				}
                            				catch(NullPointerException e) {
                            					System.out.println("Opcao invalida. Digite uma das opcoes sugeridas.");
                            				}
                            			}while(!valido);
                            			acaoDisponivel = false;
                            			break;
                            		}
                            		else {
                            			System.out.println("Nao ha pocoes disponiveis");
                            			continue;
                            		}
                            	case "f":
                            		personagem.vasculhar(mapa);
                            		break;
                            	default:
                            		System.out.println("Acao invalida.");
                        	}
                        }while(acaoDisponivel);
                    }
                default:
                    System.out.println("Comando invalido.");
            }
        }
    }

}
