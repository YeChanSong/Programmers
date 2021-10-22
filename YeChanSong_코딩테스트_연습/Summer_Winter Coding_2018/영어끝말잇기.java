import java.util.*;

class Solution {
    static HashMap<String, Boolean> used = new HashMap<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt=0;char before = words[0].charAt(0);
        for(String s: words){
            if(before != s.charAt(0)){
                answer[0] = cnt%n+1;
                answer[1] = cnt/n+1;
                break;
            }else
                before = s.charAt(s.length()-1);
            if(used.get(s) == null){
                used.put(s, true);
            }else{
                answer[0] = cnt%n+1;
                answer[1] = cnt/n+1;
                break;
            }
            cnt++;
            
        }
        
        
        return answer;
    }
}