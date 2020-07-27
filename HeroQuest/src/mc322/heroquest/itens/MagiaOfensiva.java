package mc322.heroquest.itens;

import mc322.heroquest.mapa.Combativel;

public abstract class MagiaOfensiva extends Magia {

    public MagiaOfensiva() {
    }
    //as magias ofensivas contam com um dano e alcance
    //alem disso, possuem um alvo inimigo com o objetivo de causar dano
    protected int dano;
    protected int alcance;

    public abstract boolean lancar(Combativel origem, Combativel alvo);
}
