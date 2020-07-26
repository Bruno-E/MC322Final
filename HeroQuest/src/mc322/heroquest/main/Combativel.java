package mc322.heroquest.main;

public interface Combativel {

    public void atacar(Combativel i);
    public void defender(int ataque);
    public void defesaMagica(int ataque);
    public int getInteligencia();
    public void restauraVida(int vida);
}
