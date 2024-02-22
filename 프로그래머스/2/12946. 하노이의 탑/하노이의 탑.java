import java.util.*;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> arr = new ArrayList();

        move(n, 1, 2, 3, arr);
        int[][] result = arr.stream().toArray(int[][]::new);
        return result;
    }

    private void move(int cnt, int start, int mid, int end, ArrayList arr) {
        if (cnt == 0) {
            return;
        }
        
        move(cnt - 1, start, end, mid, arr);
        arr.add(new int[]{start, end});
        move(cnt - 1, mid, start, end, arr);
    }
}