package mc322.heroquest.main;

import java.util.*;

public interface Combativel {

    public void atacar(Combativel i);
    public void defender(int ataque);
    public void defesaMagica(int ataque);
    public int getInteligencia();
}
