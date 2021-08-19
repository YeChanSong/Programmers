import java.util.*;

class Solution {
    static int answer = 0, lim;
    public int solution(int[] numbers, int target) {
        lim = numbers.length;
        dfs(0,0, target, numbers);
        return answer;
    }
    public void dfs(int idx, int sum, int target,int[] numbers){
        if(idx == lim){
            if(sum == target)
                answer++;
            return;
        }
        dfs(idx+1,sum+numbers[idx],target,numbers);
        dfs(idx+1,sum-numbers[idx],target,numbers);
        
    }
    
}