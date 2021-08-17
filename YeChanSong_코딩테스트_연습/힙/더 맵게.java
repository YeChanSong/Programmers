import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0, a=0,b=0;
        for(int i:scoville)
            pq.offer(i);
        a=pq.poll();
        while(!pq.isEmpty() && a<K){
            answer++;
            b = pq.poll();
            pq.offer(a+2*b);
            a = pq.poll();
        }
        if(pq.isEmpty() && a<K)
            answer=-1;
        return answer;
    }
}