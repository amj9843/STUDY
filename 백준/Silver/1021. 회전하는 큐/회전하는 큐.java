import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList deque = new LinkedList();
        int cnt = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();


        IntStream.range(1,N + 1).forEach(x -> deque.addLast(x));
        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            while (num != (int) deque.peekFirst()) {
                if (deque.indexOf(num) <= ((deque.size() %2 == 1) ? deque.size() /2 : deque.size() /2 - 1)) {
                    deque.addLast(deque.removeFirst());
                } else {
                    deque.addFirst(deque.removeLast());
                }
                cnt++;
            }

            deque.removeFirst();
        }

        System.out.println(cnt);
    }
}