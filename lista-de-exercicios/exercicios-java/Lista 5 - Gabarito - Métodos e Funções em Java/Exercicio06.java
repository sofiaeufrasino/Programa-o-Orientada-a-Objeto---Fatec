import java.util.Scanner;

public class Exercicio06 {
    public static int lerNumero(Scanner scanner) {
        System.out.print("Digite um número: ");
        return scanner.nextInt();
    }

    public static void mostrarLinha(int numero, int multiplicador) {
        int resultado = numero * multiplicador;
        System.out.println(numero + " x " + multiplicador + " = " + resultado);
    }

    public static void exibirTabuada(int numero) {
        for (int i = 1; i <= 10; i++) {
            mostrarLinha(numero, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = lerNumero(scanner);
        exibirTabuada(numero);

        scanner.close();
    }
}
