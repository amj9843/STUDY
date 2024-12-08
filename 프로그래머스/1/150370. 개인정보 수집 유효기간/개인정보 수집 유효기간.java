// import java.util.*;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

// class Solution {
//     static HashMap<String, Long> termsMap = new HashMap<>();
//     static LocalDate now;
    
//     public int[] solution(String today, String[] terms, String[] privacies) {
//         now = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
//         for (String term: terms) {
//             String[] termToArr = term.split(" ");
//             termsMap.put(termToArr[0], Long.valueOf(termToArr[1]));
//         }
        
//         List<Integer> trashedList = new ArrayList<>();
        
//         for (int i = 0; i < privacies.length; i++) {
//             if (isTrashed(privacies[i])) {
//                 trashedList.add(i+1);
//             }
//         }
        
//         int[] answer = new int[trashedList.size()];
        
//         for (int i = 0; i < trashedList.size(); i++) {
//             answer[i] = trashedList.get(i);
//         }
        
//         return answer;
//     }
    
//     private boolean isTrashed(String privacy) {
//         String[] privacyToArr = privacy.split(" ");
        
//         LocalDate untilDate = LocalDate.parse(privacyToArr[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"))
//             .plusMonths(termsMap.get(privacyToArr[1]));
        
//         return untilDate.isBefore(now) || untilDate.isEqual(now);
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}