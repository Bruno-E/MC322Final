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
        this.magia[0] = new MissilMagico();
        this.magia[1] = new MissilMagico();
        this.magia[2] = new MissilMagico();
        this.magia[3] = new BolaFogo();
        this.magia[4] = new Teleporte();
    }

}
