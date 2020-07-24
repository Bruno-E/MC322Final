package mc322.heroquest.main;

public enum TipoDeArmas {
    BASTAO(2),
    ESPADA_LONGA(3),
    ESPADA_CURTA(2),
    MACHADO_DE_COMBATE(4),
    LANCA(2),
    PUNHAL(1);
    
    private int bonus;
	
	private TipoDeArmas(final int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return this.bonus;
	}
}