package mc322.heroquest.main;

public abstract class MagiaOfensiva extends Magia {

    public MagiaOfensiva() {
    }
    
    protected int dano;
    protected int alcance;

    protected abstract void lancar(Combativel origem, Combativel alvo);

}
