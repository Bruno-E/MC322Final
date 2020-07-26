package mc322.heroquest.main;

import java.util.Random;

public class Tesouro extends Elemento {
    private Item[] itens;
    
    // TODO Substituir Item por Object nesta classe e fazer um try-catch com
    // um cast (Item) e um (Elemento) ao usar abrirTesouro() no game seria uma boa?
    // acho que não tem problema ser static mesmo
    //
    // Ou talvez fazer um enum com os nomes das coisas que podem sair do tesouro (TesouroPossivel),
    // retornar o enum aleatorio em abrirTesouro, fazer um switch com esse valor e spawnar no mapa
    // se for um monstro ou fazer o new item correspondente e add na mochila
    
    public Tesouro(Ponto ponto) {
    	super(ponto, false);
        itens = new Item[] {new Ouro(10), new Ouro(20), new Ouro(25),
			        		new Ouro(50),new PocaoCura(), new PocaoResiliencia(),
			        		new PocaoForca(), new PocaoVelocidade(), new ArmadilhaFlecha(ponto),
			        		new Goblin(ponto), new Esqueleto(), new Esqueleto Mago() };
    }
    public Tesouro(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
    
    public Item abrirTesouro(){
        Random valor = new Random();
        return itens[valor.nextInt(12)];
    }
}







