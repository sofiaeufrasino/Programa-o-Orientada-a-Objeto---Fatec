import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[8];

        for (int i = 0; i < v.length; i++) {
            v[i] = sc.nextInt();
        }

        int maior = v[0];
        int menor = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] > maior) maior = v[i];
            if (v[i] < menor) menor = v[i];
        }

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        sc.close();
    }
}
