import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder answer = new StringBuilder();

        for(Character c : a.toCharArray()){
            answer.append(
                (Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        
        System.out.println(answer);
        
        sc.close();
    }
}