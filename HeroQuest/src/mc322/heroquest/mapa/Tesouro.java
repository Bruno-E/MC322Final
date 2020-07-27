package mc322.heroquest.mapa;

import java.util.Random;

import mc322.heroquest.itens.Ouro;
import mc322.heroquest.itens.PocaoCura;
import mc322.heroquest.itens.PocaoForca;
import mc322.heroquest.itens.PocaoResiliencia;
import mc322.heroquest.itens.PocaoVelocidade;

public class Tesouro extends Elemento {
    private Coletavel[] itens;
    
    // TODO Substituir Item por Object nesta classe e fazer um try-catch com
    // um cast (Item) e um (Elemento) ao usar abrirTesouro() no game seria uma boa?
    // acho que não tem problema ser static mesmo
    //
    // Ou talvez fazer um enum com os nomes das coisas que podem sair do tesouro (TesouroPossivel),
    // retornar o enum aleatorio em abrirTesouro, fazer um switch com esse valor e spawnar no mapa
    // se for um monstro ou fazer o new item correspondente e add na mochila
    
    public Tesouro(Ponto ponto) {
    	super(ponto, false);
        itens = new Coletavel[] {new Ouro(10), new Ouro(20), new Ouro(25),
			        		new Ouro(50), new PocaoCura(), new PocaoResiliencia(),
			        		new PocaoForca(), new PocaoVelocidade(), new ArmadilhaFlecha(ponto),
			        		new Goblin(ponto), new Esqueleto(ponto), new EsqueletoMago(ponto) };
    }
    public Tesouro(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
    
    // TODO Onde ela eh usada?
    public Coletavel abrirTesouro(){
        Random valor = new Random();
        return itens[valor.nextInt(12)];
    }
    @Override
	public String toString(){
        return "Te";
    }
}







