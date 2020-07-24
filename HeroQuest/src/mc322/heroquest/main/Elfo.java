package mc322.heroquest.main;

import java.util.*;

/**
 *
 */
public class Elfo extends CriaturaMagica {

    private static int VIDA_INICIAL = 6;
    private static int INT_INICIAL = 4;
    private static int ATQ_INICIAL = 2;
    private static int DFS_INICIAL = 2;

    public Elfo(String nome) {
        super(nome);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.magias = new Magia[5];
        this.magias[0] = new CuraSimples();
    }

}
