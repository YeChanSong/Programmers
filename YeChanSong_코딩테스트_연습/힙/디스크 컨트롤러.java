import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, endTime=-1;
        boolean flag = false;
        int[] tmp = new int[2];
        Arrays.sort(jobs,(int[] a, int[] b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)-> Integer.compare(a[1],b[1]));
        for(int[] job: jobs){
            flag = false;
            if(endTime>job[0]){
                // 현재 작업중
                pq.offer(job);
            } else if(pq.isEmpty()){
                // 작업 수행하지 않을 때 들어온 작업
                endTime = job[0] + job[1];
                answer += job[1];
            } else {
                // 새로운 작업 수행
                if(endTime==job[0]){
                    pq.offer(job);
                    flag = true;
                }
                while(endTime<=job[0]){
                    tmp = pq.poll();
                    answer += endTime - tmp[0] + tmp[1];
                    endTime += tmp[1];
                }
                if(!flag)
                    pq.offer(job);
            }
        }
        while(!pq.isEmpty()){
            tmp = pq.poll();
            if(endTime>=tmp[0]){
                answer += endTime - tmp[0] + tmp[1];
                endTime += tmp[1];
            }else{
                answer += tmp[1];
                endTime = tmp[0]+tmp[1];
            }
        }
        
        answer/=jobs.length;
        
        return answer;
    }
}