package mc322.heroquest.main;

public interface Coletavel {
	//a interface coletavel e aplicavel para objetos que podem estar contidos em um bau
	//contem monstros e armadilhas, alem de pocoes e ouro
	//a funcao coleta define o que ocorre ao encontrar determinado objeto em um bau
	public boolean coletar(Heroi heroi, Mapa mapa);
}
