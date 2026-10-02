import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usuarioCorreto = "admin";
        String senhaCorreta = "1234";
        boolean acessoPermitido = false;

        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Usuário: ");
            String usuario = sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
                acessoPermitido = true;
                System.out.println("Acesso permitido");
                break;
            } else {
                System.out.println("Dados incorretos");
            }
        }

        if (!acessoPermitido) {
            System.out.println("Conta bloqueada");
        }

        sc.close();
    }
}
