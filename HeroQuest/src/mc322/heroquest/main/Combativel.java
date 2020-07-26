package mc322.heroquest.main;

public interface Combativel {
	//a interface combativel representa os seres que podem entrar em combate
	//e aplicavel para monstros e herois
	//possui os metodos necessarios para que o combate ocorra
    public void atacar(Combativel i);
    public void defender(int ataque);
    public void defesaMagica(int ataque);
    public int getInteligencia();
    public void restauraVida(int vida);
}
