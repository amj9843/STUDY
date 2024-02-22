import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long answer = 1L;

        int N = sc.nextInt();
        int M = sc.nextInt();
        int A = sc.nextInt();
        int H = sc.nextInt();

        for(int i = 0; i < N-1; i ++){
            answer = (answer * M)%1000000007;
        }
        System.out.println(answer);
    }
}