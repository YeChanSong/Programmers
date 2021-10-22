import java.util.*;

class Solution {
    static int[] cache;
    public int solution(int n, int[] money) {
        int answer = 0;
        cache = new int[n+1];
        cache[0]=1;
        for(int k: money){
            for(int p=k;p<=n;p++)
                cache[p] =(cache[p]%1000000007 + cache[p-k]%1000000007)%1000000007;
        }
        answer = cache[n]%1000000007;
        return answer;
    }
}