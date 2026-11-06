public class Circulo {
    private double raio;
    private Ponto2D centro;

    public Circulo(double raio, Ponto2D centro) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        this.raio = raio;
        this.centro = new Ponto2D(centro);
    }

    public Circulo(double raio) {
        this(raio, new Ponto2D());
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        this.raio = raio;
    }

    public Ponto2D getCentro() {
        return centro.clone();
    }

    public void inflar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
        raio += valor;
    }

    public void inflar() {
        inflar(1);
    }

    public void desinflar(double valor) {
        if (valor < 0 || valor > raio) {
            throw new IllegalArgumentException("Valor inválido para diminuir o raio.");
        }
        raio -= valor;
    }

    public void desinflar() {
        desinflar(1);
    }

    public void mover() {
        centro.mover();
    }

    public void mover(double x, double y) {
        centro.mover(x, y);
    }

    public void mover(Ponto2D ponto) {
        centro.mover(ponto);
    }

    public double area() {
        return Math.PI * raio * raio;
    }
}
