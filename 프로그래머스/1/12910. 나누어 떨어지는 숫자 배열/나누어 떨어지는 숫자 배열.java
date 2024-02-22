import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        for(int num : arr) {
            if (num % divisor == 0) {
                if (array.size() == 0 || num >= array.get(array.size()-1)) {
                    array.add(num);
                } else {
                    for (int i = 0; i < array.size(); i++) {
                        if (num < array.get(i)) {
                            array.add(i, num);
                            break;
                        }
                    }
                }
            }
        }

        if (array.size() == 0) array.add(-1);

        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }

        return result;
    }
}