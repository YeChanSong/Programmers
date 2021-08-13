import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = dfsAll(n,computers);
        return answer;
    }
    public int dfsAll(int n, int[][] adj){
        int cnt=0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, adj);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int idx, int[][] adj){
        visited[idx] = true;
        for(int i=0;i<adj.length;i++){
            if(adj[idx][i]==1 && !visited[i]){
                dfs(i,adj);
            }
        }
    }
}