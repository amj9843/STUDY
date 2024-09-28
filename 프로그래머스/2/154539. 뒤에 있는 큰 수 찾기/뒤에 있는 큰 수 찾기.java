import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                int idx = stack.size() - 1;
                while (idx > -1) {
                    int cur = stack.get(idx);
                    
                    if (numbers[i] > numbers[cur]) {
                        answer[cur] = numbers[i];
                        stack.remove(idx);
                    } else {
                        break; 
                    }
                    idx--;
                }
                stack.add(i); 
            }
        }

        for (int i : stack) {
            answer[i] = -1;
        }
        
        return answer;
    }
}