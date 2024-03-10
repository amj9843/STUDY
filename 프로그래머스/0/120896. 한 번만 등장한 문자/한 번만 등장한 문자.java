class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] countArr = new int['z'-'a' + 1];
        
        for (char c : s.toCharArray()) {
            countArr[c - 'a']++;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 1) answer.append((char) (i + 'a'));
        }

        return answer.toString();
    }
}