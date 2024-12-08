import java.util.*;

class Solution {
    private static HashMap<String, Integer> termsMap = new HashMap<>();
    private static int todayDate;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> trashedNumbers = new ArrayList<>();
        todayDate = calculateDate(today);
            
        for (String term: terms) {
            String[] termInfo = term.split("\\s");
            termsMap.put(termInfo[0], Integer.valueOf(termInfo[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            if (isTrashed(privacies[i])) trashedNumbers.add(i+1);
        }
        
        int[] answer = new int[trashedNumbers.size()];
        for(int i = 0; i < trashedNumbers.size(); i++) {
            answer[i] = trashedNumbers.get(i);
        }
        
        return answer;
    }
    
    private boolean isTrashed(String privacy) {
        String[] signDateInformation = privacy.split(" ");
        
        return calculateDate(signDateInformation[0]) + termsMap.get(signDateInformation[1])*28 <= todayDate;
    }
    
    private int calculateDate(String date) {
        String dateInfo[] = date.split("\\.");
        
        int year = Integer.valueOf(dateInfo[0]);
        int month = Integer.valueOf(dateInfo[1]);
        int day = Integer.valueOf(dateInfo[2]);
        
        return year*12*28 + month*28 + day;
    }
}