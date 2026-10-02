import java.util.Random;
import java.util.Scanner;

public class Exercicio15 {
    public static void iniciarJogo() {
        System.out.println("=== JOGO DE BATALHA ===");
        System.out.println("Derrote o monstro para vencer.");
    }

    public static void mostrarMenu() {
        System.out.println("1 - Atacar");
        System.out.println("2 - Curar");
        System.out.println("3 - Ver status");
    }

    public static int lerOpcao(Scanner scanner) {
        System.out.print("Escolha: ");
        return scanner.nextInt();
    }

    public static int atacar() {
        Random random = new Random();
        return random.nextInt(16) + 5;
    }

    public static int receberDano() {
        Random random = new Random();
        return random.nextInt(11) + 5;
    }

    public static int curar(int vida) {
        vida = vida + 15;

        if (vida > 100) {
            vida = 100;
        }

        return vida;
    }

    public static void mostrarStatus(int vidaJogador, int vidaMonstro) {
        System.out.println("Vida do jogador: " + vidaJogador);
        System.out.println("Vida do monstro: " + vidaMonstro);
    }

    public static boolean verificarVitoria(int vidaMonstro) {
        return vidaMonstro <= 0;
    }

    public static boolean verificarDerrota(int vidaJogador) {
        return vidaJogador <= 0;
    }

    public static void encerrarJogo(boolean venceu) {
        if (venceu) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você perdeu!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vidaJogador = 100;
        int vidaMonstro = 80;

        iniciarJogo();

        while (vidaJogador > 0 && vidaMonstro > 0) {
            mostrarMenu();

            int opcao = lerOpcao(scanner);

            if (opcao == 1) {
                int danoJogador = atacar();
                vidaMonstro = vidaMonstro - danoJogador;

                System.out.println("Você causou " + danoJogador + " de dano.");

                if (!verificarVitoria(vidaMonstro)) {
                    int danoMonstro = receberDano();
                    vidaJogador = vidaJogador - danoMonstro;

                    System.out.println("O monstro causou " + danoMonstro + " de dano.");
                }
            } else if (opcao == 2) {
                vidaJogador = curar(vidaJogador);
                System.out.println("Você recuperou vida.");
            } else if (opcao == 3) {
                mostrarStatus(vidaJogador, vidaMonstro);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        boolean venceu = verificarVitoria(vidaMonstro);
        encerrarJogo(venceu);

        scanner.close();
    }
}
