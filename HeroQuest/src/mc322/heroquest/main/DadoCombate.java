package mc322.heroquest.main;

public class DadoCombate extends Dado {

    private Lado[] faces;

    public DadoCombate() {
        faces = new Lado[] {Lado.ESCUDO_MONSTRO, Lado.ESCUDO_HEROI, Lado.ESCUDO_HEROI, Lado.CAVEIRA, Lado.CAVEIRA, Lado.CAVEIRA};
    }

    public Lado jogar() {
        return faces[aleatorio(6)]; //retorna um Lado do dado de combate que e composto por escudos e caveiras
    }

}
