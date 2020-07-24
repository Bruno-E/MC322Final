package mc322.heroquest.main;

import java.util.*;

/**
 *
 */
public class Feiticeiro extends CriaturaMagica {
    private static int VIDA_INICIAL = 4;
    private static int INT_INICIAL = 6;
    private static int ATQ_INICIAL = 1;
    private static int DFS_INICIAL = 2;
    /**
     * Default constructor
     */
    public Feiticeiro(String nome) {
        super(nome);
        this.vida = VIDA_INICIAL;
        this.inteligencia = INT_INICIAL;
        this.bonusAtaque = ATQ_INICIAL;
        this.bonusDefesa = DFS_INICIAL;
        this.magias = new Magia[10];
        this.magias[0] = new MissilMagico();
        this.magias[1] = new MissilMagico();
        this.magias[2] = new MissilMagico();
        this.magias[3] = new BolaFogo();
        this.magias[4] = new Teleporte();
    }

}
