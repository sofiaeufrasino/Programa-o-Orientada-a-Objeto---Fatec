import java.util.Scanner;

public class Exercicio09 {
    public static void mostrarMenu() {
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
    }

    public static double depositar(double saldo, double valor) {
        return saldo + valor;
    }

    public static double sacar(double saldo, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return saldo;
        }

        return saldo - valor;
    }

    public static void consultarSaldo(double saldo) {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 1000;

        mostrarMenu();

        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.print("Valor do depósito: ");
            double valor = scanner.nextDouble();
            saldo = depositar(saldo, valor);
        } else if (opcao == 2) {
            System.out.print("Valor do saque: ");
            double valor = scanner.nextDouble();
            saldo = sacar(saldo, valor);
        }

        consultarSaldo(saldo);

        scanner.close();
    }
}
