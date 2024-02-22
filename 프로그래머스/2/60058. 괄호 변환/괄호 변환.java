import java.util.Stack;

class Solution {
   public String solution(String p) {
        if (p.length() < 2) {
            return "";
        }

        StringBuilder u = new StringBuilder();
        String v = new String();
        int cnt = 0;

        char[] str = p.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                cnt++;
            } else if(p.charAt(i) == ')') {
                cnt--;
            } if(cnt == 0) {
                u.append(p.substring(0, i+1));
                v = p.substring(i+1);
                break;
            }
        }

        if (isCorrect(u.toString())) {
            u.append(solution(v));
        } else {
            StringBuilder remake = new StringBuilder();

            remake.append("(").append(solution(v)).append(")");

            u.deleteCharAt(0).deleteCharAt(u.length()-1);

            remake.append(reverse(u.toString()));

            return remake.toString();
        }

        return u.toString();
    }

    public boolean isBalanced(String s) {
        char[] str = s.toCharArray();
        int result = 0;

        for (char c : str) {
            if (c == '(') result++;
            else result--;
        }

        return result == 0;
    }

    public boolean isCorrect(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char c : str) {
            if (c == '(') {
                stack.push(1);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
    
    public String reverse(String s) {
        char[] str = s.toCharArray();
        
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                str[i] = ')';
            } else {
                str[i] = '(';
            }
        }
        
        return new String(str);
    }
}