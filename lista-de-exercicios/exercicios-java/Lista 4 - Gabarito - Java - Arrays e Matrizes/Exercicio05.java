import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pares = 0;

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            if (n % 2 == 0) pares++;
        }

        System.out.println(pares);
        sc.close();
    }
}
