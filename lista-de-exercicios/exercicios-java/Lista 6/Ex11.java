public class Reta {
    private double a; // Coeficiente angular
    private double b; // Coeficiente linear

    public Reta(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Cria a reta que passa por dois pontos.
    public Reta(Ponto2D p1, Ponto2D p2) {
        if (Double.compare(p1.getX(), p2.getX()) == 0) {
            throw new IllegalArgumentException(
                    "Os pontos possuem o mesmo x: não formam uma reta y = ax + b.");
        }

        a = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        b = p1.getY() - a * p1.getX();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public boolean pertence(Ponto2D ponto) {
        double yCalculado = a * ponto.getX() + b;
        return Math.abs(yCalculado - ponto.getY()) < 0.000000001;
    }

    // Retorna null quando as retas são paralelas ou coincidentes.
    public Ponto2D intersecao(Reta outra) {
        if (Double.compare(a, outra.a) == 0) {
            return null;
        }

        double x = (outra.b - b) / (a - outra.a);
        double y = a * x + b;
        return new Ponto2D(x, y);
    }

    @Override
    public String toString() {
        if (b < 0) {
            return "y = " + a + "x - " + Math.abs(b);
        }
        return "y = " + a + "x + " + b;
    }
}
