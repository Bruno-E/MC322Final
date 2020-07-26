package mc322.heroquest.main;

public abstract class MagiaOfensiva extends Magia {

    public MagiaOfensiva() {
    }
    //as magias ofensivas contam com um dano e alcance
    //alem disso, possuem um alvo inimigo com o objetivo de causar dano
    protected int dano;
    protected int alcance;

    protected abstract boolean lancar(Combativel origem, Combativel alvo);
}
