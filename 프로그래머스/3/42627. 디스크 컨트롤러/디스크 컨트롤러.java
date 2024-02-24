import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        if (jobs == null) {
            return 0;
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int index = 0;
        int now = 0;
        int total = 0;
        int end = 0;

        while (index < jobs.length || !heap.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= now) {
                total += (now - jobs[index][0]);
                heap.add(jobs[index++][1]);
            }

            if (!heap.isEmpty()) {
                int job = heap.remove();

                total += (heap.size() + 1) * job;
                now += job;
            } else {
                now ++;
            }
        }

        return total / jobs.length;
    }
}