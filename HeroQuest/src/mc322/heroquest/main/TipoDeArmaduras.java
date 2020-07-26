package mc322.heroquest.main;

public enum TipoDeArmaduras {
	NU(0, "Nu"),
	COTA_DE_MALHA(3, "Cota de Malha"),
	CAPACETE(1, "Capacete"),
	ESCUDO(1, "Escudo"),
	ARMADURA_DE_PLACA(4, "Armadura de Placa");
	
	//o enum TipoDeArmaduras carrega ira carregar os dados bonus que a armadura fornece pra defesa e seu nome
	private TipoDeArmaduras(final int bonus, String nome) {
		this.bonus = bonus;
		this.nome = nome;
	}
	
	private int bonus;
	private String nome;
	
	public int getBonus() {
		return this.bonus;
	}
	
	public String toString() {
		return this.nome;
	}
	
}
