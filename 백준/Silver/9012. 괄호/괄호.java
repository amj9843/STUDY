import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            ArrayDeque<Character> stack = new ArrayDeque();

            String input = sc.next();
            try {
                for (char c : input.toCharArray()) {
                    if (c == ')') {
                        stack.removeLast();
                    } else {
                        stack.addLast(c);
                    }
                }


                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } catch (Exception e) {
                System.out.println("NO");
            }
        }
    }
}
