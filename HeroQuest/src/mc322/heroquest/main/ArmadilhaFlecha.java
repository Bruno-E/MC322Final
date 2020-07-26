package mc322.heroquest.main;

public class ArmadilhaFlecha extends Armadilha{
	
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
