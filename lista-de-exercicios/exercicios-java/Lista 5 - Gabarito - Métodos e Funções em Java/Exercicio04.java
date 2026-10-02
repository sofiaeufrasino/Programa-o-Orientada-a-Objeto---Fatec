import java.util.Scanner;

public class Exercicio04 {
    public static double lerNota(Scanner scanner) {
        System.out.print("Digite a nota: ");
        return scanner.nextDouble();
    }

    public static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    public static String verificarSituacao(double media) {
        if (media >= 6) {
            return "Aprovado";
        } else if (media >= 4) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static void mostrarResultado(double media, String situacao) {
        System.out.println("Média: " + media);
        System.out.println("Situação: " + situacao);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = lerNota(scanner);
        double n2 = lerNota(scanner);
        double n3 = lerNota(scanner);

        double media = calcularMedia(n1, n2, n3);
        String situacao = verificarSituacao(media);

        mostrarResultado(media, situacao);

        scanner.close();
    }
}
