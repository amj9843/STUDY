import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        int level = 0;
        
        while (start <= end) {
            int mid = (start + end)/2;
            long totalTime = getTotalTime(diffs, times, mid);

            if (totalTime <= limit) {
                level = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return level;
    }
    
    private long getTotalTime(int[] diffs, int[] times, int level) {
        long totalTime  = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
                continue;
            }
            
            int solveTimes = diffs[i] - level;
            
            totalTime += (i == 0) ? (long) times[i] * solveTimes + times[i]
                : (long) (times[i - 1] + times[i]) * solveTimes + times[i];
        }
        
        return totalTime;
    }
}