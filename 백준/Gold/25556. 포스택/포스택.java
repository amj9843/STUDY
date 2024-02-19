import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        String strTemp = sc.nextLine();
        String[] str = strTemp.split(" ");

        boolean canClear = true;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(str[i]);

            if (stack1.empty() || stack1.peek() < value) {
                stack1.push(value);
            } else if (stack2.empty() || stack2.peek() < value) {
                stack2.push(value);
            } else if (stack3.empty() || stack3.peek() < value) {
                stack3.push(value);
            } else if (stack4.empty() || stack4.peek() < value) {
                stack4.push(value);
            } else {
                canClear = false;
                break;
            }
        }

        if (canClear) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
