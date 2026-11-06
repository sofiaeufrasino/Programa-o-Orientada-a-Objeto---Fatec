import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[5];

        for (int i = 0; i < v.length; i++) {
            v[i] = sc.nextInt();
        }

        for (int i = v.length - 1; i >= 0; i--) {
            System.out.println(v[i]);
        }

        sc.close();
    }
}
