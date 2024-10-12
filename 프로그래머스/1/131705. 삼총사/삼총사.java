import java.util.*;

class Solution {
    public int answer;
    public boolean[] visited;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        backtracking(0,0,0,number);
        return answer;
    }
    
    
    public void backtracking(int index, int depth, int sum, int[] number){
        if(depth == 3 && sum == 0){
            for(int i=0;i<visited.length;i++){
                System.out.print(visited[i]+ " ");
            }
            answer++;
        } else if (depth == 3) {
            return;
        }
        
        for(int i=index;i<number.length;i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(i+1,depth+1,sum+number[i],number);
                visited[i] = false;
            }
        }
    }
}