import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int date = ((100 - progresses[i]) % speeds[i] > 0) ?
                (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];

            if (!queue.isEmpty() && queue.peek() < date) {
                answerList.add(queue.size());
                queue.clear();
            }

            queue.add(date);
        }

        answerList.add(queue.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
