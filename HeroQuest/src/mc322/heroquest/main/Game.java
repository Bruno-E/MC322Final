package mc322.heroquest.main;

import java.util.Scanner;

public class Game {
    private boolean fim;

    public Game() {
      fim = false;
    }

    public void start() {
        System.out.println("Jogo iniciado.");
        Scanner key = new Scanner(System.in);
        Heroi personagem;
        System.out.println("Qual sera o nome do seu personagem?");
        String nome = key.nextLine();
        System.out.println("Qual sera sua classe (Digite o numero): 1.Anao, 2.Barbaro, 3.Elfo, 4.Feiticeiro.");
        int classe;
        do{
        	classe = key.nextInt();
        	if(classe == 1) {
        		personagem = new Anao(nome);
        	}
        	else if(classe == 2) {
        		personagem = new Barbaro(nome);
        	}
        	else if(classe == 3) {
        		personagem = new Elfo(nome);
        	}
        	else if(classe == 4) {
        		personagem = new Feiticeiro(nome);
        	}
        } while(classe > 4 && classe < 1);
        
        while(!fim) {
            drawBoard();
            lerInput(personagem);
            updateBoard();
        }
        System.out.println("Fim de jogo. Ate logo!");
    }

    public void lerInput(Heroi personagem) {
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
                        Scanner input = new Scanner(System.in);
                        int opcao;
                        do {
                        	acao = keyboard.nextLine();
                        	switch(acao) {
                            	case "a":
                            		if(personagem.temDuasArmas()) {
                            			System.out.println("Escolha qual arma você pretende usar(1 ou 2)");
                            			opcao = input.nextInt();
                            			if(opcao == 2) personagem.trocarArmaPrincipal();
                            		}
                            		
                            		
                            		break;
                            	case "s":
                            		if(!personagem.eMagico()) {
                            			System.out.println("Você não pode lançar magias.");
                            			break;
                            		}
                            		System.out.println("Você deseja lançar uma magia defensiva (1) ou ofensiva(2)?");
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
                                		boolean checagem = false;
                                		do {
                                			opcao = input.nextInt();
                                			try {
                                				((HeroiMagico)personagem).usarMagiaDefensiva(opcao);
                                				checagem = true;
                                			}
                                			catch(NullPointerException e) {
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
                            			//ArrayList<Monstro> monstros= mapa.monstrosAoAlcance(personagem.getPosicao(), 5);
                                		boolean checagem = false;
                                		do {
                                			opcao = input.nextInt();
                                			try {
                                				((HeroiMagico)personagem).usarMagiaOfensiva(opcao);
                                				checagem = true;
                                			}
                                			catch(NullPointerException e) {
                                				System.out.println("Opcao invalida. Digite uma das opcoes sugeridas.");
                                			}
                                		}while(!checagem); 	                           			
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
                            			}while(!valido);
                            			acaoDisponivel = false;
                            			break;
                            		}
                            		else {
                            			System.out.println("Nao ha pocoes disponiveis");
                            			continue;
                            		}
                            	case "f":
                            		//chama a funcao de olhar armadilhas no mapa
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