import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, String> replaceList = new HashMap();

        replaceList.put("zero", "0");
        replaceList.put("one", "1");
        replaceList.put("two", "2");
        replaceList.put("three", "3");
        replaceList.put("four", "4");
        replaceList.put("five", "5");
        replaceList.put("six", "6");
        replaceList.put("seven", "7");
        replaceList.put("eight", "8");
        replaceList.put("nine", "9");

        for (String key : replaceList.keySet()) {
            s = s.replaceAll(key, replaceList.get(key));
        }

        return Integer.parseInt(s);
    }
}