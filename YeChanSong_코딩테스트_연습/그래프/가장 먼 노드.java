import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] edg: edge){
            adj.get(edg[0]-1).add(edg[1]-1);
            adj.get(edg[1]-1).add(edg[0]-1);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        dist[0]=0;
        q.offer(0);
        int itm = 0;
        while(!q.isEmpty()){
            itm = q.poll();
            for(int nxt: adj.get(itm)){
                if(dist[nxt]==-1){
                    dist[nxt] = dist[itm]+1;
                    q.offer(nxt);
                }
            }
        }
        int max = -1;
        for(int i: dist){
            if(max<i)
                max=i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dist[i]==max){
                ans.add(i);
            }
        }
        answer= ans.size();
        return answer;
    }
}