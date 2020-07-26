package mc322.heroquest.main;

import java.util.ArrayList;
import java.util.Scanner;

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
    	
    	//TODO Construir mapa correspondente
    	
    	return mapa;
    }
    
    
    private Mapa construirBusca10() {
    	Mapa mapa = new Mapa();
    	
    	//TODO Construir mapa correspondente
    	
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
        				   "\n(1. Busca 3, 2. Busca 2, 3. Busca 10, 42. aleatorio)");
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
        			personagem.setPosicao(linha, coluna);
        			break;
        		case 3:
        			mapa = construirBusca10();
        			inputCorreto = true;
        			//TODO posicao inicial no mapa
        			personagem.setPosicao(linha, coluna);
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
        	
        } while(inputCorreto);
        
        
        while(!fim) {

            drawBoard();
            lerInput(personagem);
            
            updateBoard();

            /* printar mapa
             * System.out.println(mapa);
        	*/
            lerInput(personagem, mapa);
            mapa.atualizarMonstros(personagem);
            if(personagem.estaMorto()) fim = true;

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
