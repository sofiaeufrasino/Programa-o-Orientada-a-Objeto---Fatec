public class ExemploMain {
    public static void main(String[] args) {
        // Exercício 1: Contador
        Contador contador = new Contador();
        contador.incrementar();
        contador.incrementar();
        System.out.println("Contador: " + contador.getValor());

        // Exercício 2: Ponto2D
        Ponto2D ponto1 = new Ponto2D(3, 4);
        Ponto2D ponto2 = new Ponto2D(0, 0);
        System.out.println("Distância: " + ponto1.distancia(ponto2));

        // Exercício 3: Número complexo
        NumeroComplexo numero = new NumeroComplexo(3, 4);
        System.out.println("Número complexo: " + numero);
        System.out.println("Módulo: " + numero.modulo());

        // Exercício 11: Matriz
        Matriz matriz = new Matriz(2, 2);
        matriz.setElemento(0, 0, 1);
        matriz.setElemento(1, 1, 1);
        System.out.println("É identidade? " + matriz.ehIdentidade());
    }
}
