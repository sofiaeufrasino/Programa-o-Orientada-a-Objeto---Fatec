import java.util.Random;
import java.util.Scanner;

public class Exercicio11 {
    public static int sortearNumero() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static int lerPalpite(Scanner scanner) {
        System.out.print("Digite seu palpite: ");
        return scanner.nextInt();
    }

    public static boolean verificarAcerto(int palpite, int numeroSecreto) {
        return palpite == numeroSecreto;
    }

    public static void mostrarDica(int palpite, int numeroSecreto) {
        if (palpite < numeroSecreto) {
            System.out.println("Tente um número maior.");
        } else {
            System.out.println("Tente um número menor.");
        }
    }

    public static void mostrarVitoria(int tentativas) {
        System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroSecreto = sortearNumero();
        int tentativas = 0;
        boolean acertou = false;

        while (!acertou) {
            int palpite = lerPalpite(scanner);
            tentativas++;

            if (verificarAcerto(palpite, numeroSecreto)) {
                acertou = true;
                mostrarVitoria(tentativas);
            } else {
                mostrarDica(palpite, numeroSecreto);
            }
        }

        scanner.close();
    }
}
