package mc322.heroquest.main;

import java.util.Random;

public class Tesouro extends Elemento {
    private Item[] itens;
    
    // TODO Substituir Item por Object nesta classe e fazer um try-catch com
    // um cast (Item) e um (Elemento) ao usar abrirTesouro() no game seria uma boa?
    
    public Tesouro(Ponto ponto) {
    	super(ponto, false);
        itens = new Item[] {new Ouro(10), new Ouro(20), new Ouro(25),
			        		new Ouro(50),new PocaoCura(), new PocaoResiliencia(),
			        		new PocaoForca(), new PocaoVelocidade(), new ArmadilhaFlecha(ponto),
			        		new Goblin(), new Esqueleto(), new Esqueleto Mago() };
    }
    public Item abrirTesouro(){
        Random valor = new Random();
        return itens[valor.nextInt(12)];
    }
}
