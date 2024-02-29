import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] countOneArray = new int[20];
        long answer = 0L;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            int member = sc.nextInt();
            int index = 0;

            while (member != 0) {
                if (member % 2 == 1) {
                    countOneArray[index]++;
                }
                member /= 2;
                index++;
            }

            if (index > maxIdx) maxIdx = index;
        }

        for (int i = 0; i < maxIdx; i++){
            answer += (1L << i) * countOneArray[i] * (N - countOneArray[i]);
        }

        System.out.println(answer);
    }
}