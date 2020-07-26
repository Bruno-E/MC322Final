package mc322.heroquest.main;

public enum TipoDeArmaduras {
	COTA_DE_MALHA(3, "Cota de Malha"),
	CAPACETE(1, "Capacete"),
	ESCUDO(1, "Escudo"),
	ARMADURA_DE_PLACA(4, "Armadura de Placa");
	
	
	private TipoDeArmaduras(final int bonus, String nome) {
		this.bonus = bonus;
		this.nome = nome;
	}
	
	private int bonus;
	private String nome;
	
}
