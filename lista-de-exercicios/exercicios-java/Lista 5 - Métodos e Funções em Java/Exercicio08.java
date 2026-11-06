import java.util.Scanner;

public class Exercicio08 {
    public static String lerNome(Scanner scanner) {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public static int lerIdade(Scanner scanner) {
        System.out.print("Idade: ");
        return scanner.nextInt();
    }

    public static String lerCidade(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Cidade: ");
        return scanner.nextLine();
    }

    public static void mostrarResumo(String nome, int idade, String cidade) {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);

        System.out.println("Cidade: " + cidade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = lerNome(scanner);
        int idade = lerIdade(scanner);
        String cidade = lerCidade(scanner);

        mostrarResumo(nome, idade, cidade);

        scanner.close();
    }
}
