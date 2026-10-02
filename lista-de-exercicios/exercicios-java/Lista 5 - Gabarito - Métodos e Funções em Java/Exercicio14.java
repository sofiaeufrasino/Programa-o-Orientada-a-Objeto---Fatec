import java.util.Scanner;

public class Exercicio14 {
    public static void mostrarMenu() {
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
        System.out.println("0 - Encerrar");
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
        System.out.println("Saldo: R$ " + saldo);
    }

    public static void encerrarSistema() {
        System.out.println("Sistema encerrado.");
    }

    public static double lerValor(Scanner scanner) {
        System.out.print("Digite o valor: ");
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 1000;
        int opcao;

        do {
            mostrarMenu();

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                double valor = lerValor(scanner);
                saldo = depositar(saldo, valor);
            } else if (opcao == 2) {
                double valor = lerValor(scanner);
                saldo = sacar(saldo, valor);
            } else if (opcao == 3) {
                consultarSaldo(saldo);
            } else if (opcao == 0) {
                encerrarSistema();
            } else {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
