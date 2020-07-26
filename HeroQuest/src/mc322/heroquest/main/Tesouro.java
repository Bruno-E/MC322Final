package mc322.heroquest.main;

import java.util.Random;

public class Tesouro extends Elemento {
    private Item[] itens;
    public Tesouro() {
        itens = new Item[] {new ouro(10), new ouro(20), new ouro(25), new ouro(50),new pocaoCura(), new pocaoResiliencia(), new pocaoForca(), new pocaoVelocidade(), new ArmadilhaFlecha(),new Goblin(), new Esqueleto(), new Esqueleto Mago()};
    }
    public Item abrirTesouro(){
        Random valor = new Random();
        return itens[valor.nextInt(12)];
    }
}
