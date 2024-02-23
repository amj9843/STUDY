import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));

        int cnt = 0;
        while(!queue.isEmpty()) {
            int data = queue.remove();
            cnt++;

            if (cnt%K == 0) {
                result.add(data);
            } else {
                queue.add(data);
            }
        }

        String results = result.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("<" + results + ">");
    }
}