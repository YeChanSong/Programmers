import java.util.*;
class Solution {
    public int solution(int len, int w, int[] tw) {
        int answer = 0, qsum =0, idx=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<len;i++)
            q.offer(0);
        while(idx<tw.length){
            if(q.size()==len){
                qsum -= q.poll();
            }
            if(qsum+tw[idx]<=w){
                q.offer(tw[idx]);
                qsum+=tw[idx];
                idx++;
            }
            else{
                q.offer(0);
            }
            answer++;
        }
        while(q.size()>0){
            q.poll();
            answer++;
        }
        return answer;
    }
}