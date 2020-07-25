package mc322.heroquest.main;

public class ArmadilhaFlecha extends Armadilha{
	
	ArmadilhaFlecha(Ponto posicao) {
		super(posicao);
		this.dano = 1;
	}
	//
	@Override
	protected void ativar(Heroi heroi) {
		heroi.perdeVida(dano);
	}
}
