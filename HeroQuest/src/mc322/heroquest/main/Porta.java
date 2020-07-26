package mc322.heroquest.main;

public class Porta {
    private Ponto ponto0, ponto1;

    public Porta(Ponto ponto0, Ponto ponto1) {
        this.ponto0 = ponto0;
        this.ponto1 = ponto1;
    }

    public Ponto[] getPontos() {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = ponto0;
        pontos[1] = ponto1;
        return pontos;
    }
        @Override 
    protected String toString(){
        return "Po"
    }

}
