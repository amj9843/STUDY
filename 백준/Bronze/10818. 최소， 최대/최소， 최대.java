import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int min = 0;
        int max = 0;

        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();

            if (i == 0 || num < min) {
                min = num;
            }

            if (i == 0 || num > max) {
                max = num;
            }
        }

        System.out.printf("%d %d", min, max);
    }
}