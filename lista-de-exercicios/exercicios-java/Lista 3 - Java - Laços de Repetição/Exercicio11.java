import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;

        do {
            System.out.print("Digite um número entre 1 e 10: ");
            numero = sc.nextInt();

            if (numero < 1 || numero > 10) {
                System.out.println("Número inválido.");
            }
        } while (numero < 1 || numero > 10);

        System.out.println("Número válido: " + numero);

        sc.close();
    }
}
