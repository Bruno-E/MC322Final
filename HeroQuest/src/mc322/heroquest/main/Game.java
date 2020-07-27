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
        			mapa.construirBusca3();
        			inputCorreto = true;
        			// posicao inicial
        			personagem.setPosicao(1, 11);
        			break;
        		case 2:
        			mapa.construirBusca2();
        			inputCorreto = true;
        			//TODO posicao inicial no mapa
        			personagem.setPosicao(9, 10);
        			break;
        		case 3:
        			mapa.construirBusca13();
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
