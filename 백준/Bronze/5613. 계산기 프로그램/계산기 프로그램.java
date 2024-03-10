import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = sc.nextInt();
        String str = sc.nextLine();

        while (!str.equals("=")) {
            switch (str) {
                case "+":
                    answer += sc.nextInt();
                    break;
                case "-":
                    answer -= sc.nextInt();
                    break;
                case "*":
                    answer *= sc.nextInt();
                    break;
                case "/":
                    answer /= sc.nextInt();
                    break;
                default:
                    break;
            }

            str = sc.nextLine();
        }

        System.out.println(answer);
    }
}