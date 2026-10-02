import java.util.Random;
import java.util.Scanner;

public class Exercicio12 {
    public static void mostrarMenu() {
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
    }

    public static int jogadaComputador() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public static int jogadaJogador(Scanner scanner) {
        System.out.print("Escolha sua jogada: ");
        return scanner.nextInt();
    }

    public static String converterJogada(int jogada) {
        if (jogada == 1) {
            return "Pedra";
        } else if (jogada == 2) {
            return "Papel";
        } else if (jogada == 3) {
            return "Tesoura";
        } else {
            return "Inválida";
        }
    }

    public static String verificarVencedor(int jogador, int computador) {
        if (jogador == computador) {
            return "Empate";
        }

        if (
            jogador == 1 && computador == 3 ||
            jogador == 2 && computador == 1 ||
            jogador == 3 && computador == 2
        ) {
            return "Jogador venceu";
        }

        return "Computador venceu";
    }

    public static void mostrarResultado(int jogador, int computador, String resultado) {
        System.out.println("Jogador: " + converterJogada(jogador));
        System.out.println("Computador: " + converterJogada(computador));
        System.out.println("Resultado: " + resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarMenu();

        int jogador = jogadaJogador(scanner);
        int computador = jogadaComputador();

        String resultado = verificarVencedor(jogador, computador);

        mostrarResultado(jogador, computador, resultado);

        scanner.close();
    }
}
