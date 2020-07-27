package mc322.heroquest.mapa;

public class ArmadilhaFlecha extends Armadilha{
	//a armadilha de flecha é a mais padrao e apenas causa 1 de dano no heroi
	ArmadilhaFlecha(Ponto posicao) {
		super(posicao);
		this.dano = 1;
	}
	public ArmadilhaFlecha(int linha, int coluna) {
    	this(new Ponto(linha, coluna));
    }
	
	@Override
	protected void ativar(Heroi heroi) {
		heroi.perdeVida(dano);
	}
}
