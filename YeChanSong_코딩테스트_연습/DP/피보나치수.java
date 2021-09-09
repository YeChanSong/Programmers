import java.util.*;

class Solution {
    static int[] cache;
    public int solution(int n) {
        cache = new int[n+1];
        Arrays.fill(cache,-1);
        return recur(n);
    }
    public static int recur(int n){
        if(n==1 || n==0)
            return n;
        if(cache[n]!=-1)
            return cache[n];
        return cache[n] = (recur(n-2)%1234567+recur(n-1)%1234567)%1234567;
    }
}