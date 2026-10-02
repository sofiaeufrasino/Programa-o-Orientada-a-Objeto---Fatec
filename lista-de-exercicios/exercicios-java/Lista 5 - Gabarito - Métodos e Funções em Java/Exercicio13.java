import java.util.Scanner;

public class Exercicio13 {
    public static String criarPersonagem(Scanner scanner) {
        System.out.print("Digite o nome do personagem: ");
        return scanner.nextLine();
    }

    public static void mostrarStatus(String nome, int vida) {
        System.out.println("Personagem: " + nome);
        System.out.println("Vida: " + vida);
    }

    public static int atacar() {
        return 10;
    }

    public static int receberDano(int vida, int dano) {
        vida = vida - dano;

        if (vida < 0) {
            vida = 0;
        }

        return vida;
    }

    public static int curar(int vida) {
        vida = vida + 15;

        if (vida > 100) {
            vida = 100;
        }

        return vida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = criarPersonagem(scanner);
        int vida = 100;

        mostrarStatus(nome, vida);

        int dano = atacar();
        vida = receberDano(vida, dano);

        System.out.println("Após receber dano:");
        mostrarStatus(nome, vida);

        vida = curar(vida);

        System.out.println("Após cura:");
        mostrarStatus(nome, vida);

        scanner.close();
    }
}
