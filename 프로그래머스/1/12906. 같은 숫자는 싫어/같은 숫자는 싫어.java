import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && answer.get(answer.size()-1) != arr[i]) {
                answer.add(arr[i]);
            } else if (i == 0) {
                answer.add(arr[i]);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}