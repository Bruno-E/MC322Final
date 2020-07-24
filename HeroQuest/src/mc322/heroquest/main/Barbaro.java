package mc322.heroquest.main;

import java.util.*;

public class Barbaro extends Heroi {

    private static int VIDA_INICIAL = 8;
    private static int INT_INICIAL = 2;
    private static int ATQ_INICIAL = 3;
    private static int DFS_INICIAL = 2;

    public Barbaro(String nome) {
        super(nome);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
    }

}
