import java.util.Scanner;

public class Exercicio03 {
    public static int lerNumero(Scanner scanner) {
        System.out.print("Digite um número: ");
        return scanner.nextInt();
    }

    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public static void mostrarResultado(boolean par) {
        if (par) {
            System.out.println("Número par");
        } else {
            System.out.println("Número ímpar");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = lerNumero(scanner);
        boolean par = ehPar(numero);
        mostrarResultado(par);

        scanner.close();
    }
}
