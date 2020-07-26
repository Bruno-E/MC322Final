package mc322.heroquest.main;

public enum TipoDeArmas {
	PUNHO(0, "Punho"),
    BASTAO(2, "Bastao"),
    ESPADA_LONGA(3, "Espada Longa"),
    ESPADA_CURTA(2, "Espada Curta"),
    MACHADO_DE_COMBATE(4, "Machado de Combate"),
    LANCA(2, "Lanca"),
    PUNHAL(1, "Punhal");
    
	//o enum TipoDeArmas carrega o bonus que a arma fornece durante o ataque e o nome
    private int bonus;
    private String nome;
	
	private TipoDeArmas(final int bonus, String nome) {
		this.bonus = bonus;
		this.nome = nome;
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	public String toString() {
		return this.nome;
	}
}