import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        if (priorities == null || location > priorities.length) {
            return 0;
        }

        Queue<Integer> arr = new LinkedList<>();
        Arrays.stream(priorities).forEach(x -> arr.add(x));

        int max = Arrays.stream(priorities).max().getAsInt();

        int cnt = 0;
        int idx = 0;
        while (!arr.isEmpty()) {
            while (!arr.contains(max)) {
                max --;
            }

            int data = arr.remove();
            if (data == max) {
                cnt++;
                arr.add(0);
                
                if (idx % priorities.length == location) return cnt;
            } else {
                arr.add(data);
            }

            idx++;
        }

        return cnt;
    }
}