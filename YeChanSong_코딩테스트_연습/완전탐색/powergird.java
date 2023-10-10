import java.util.*;

class Solution {

    private static int[][] adj;
    private static boolean[] visited;
    private static int diff = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        defaultSetting(n, wires);
        ArrayDeque<Integer> towerCnt;
        for(int i=0;i<wires.length;i++) {
            towerCnt = new ArrayDeque<>();
            visited = new boolean[n];
            adj[wires[i][0]-1][wires[i][1]-1] = 0;
            adj[wires[i][1]-1][wires[i][0]-1] = 0;
            for(int j=0;j<n;j++) {
                if(!visited[j]) towerCnt.offerLast(dfs(n, j));
            }
            adj[wires[i][0]-1][wires[i][1]-1] = 1;
            adj[wires[i][1]-1][wires[i][0]-1] = 1;
            int diff = Math.abs(towerCnt.pollFirst() - towerCnt.pollFirst());
            answer = answer > diff ? diff : answer;
        }

        return answer;
    }

    private static void defaultSetting(int n, int[][] wires) {
        adj = new int[n][n];
        for(int i=0;i<wires.length;i++) {
            adj[wires[i][0]-1][wires[i][1]-1] = 1;
            adj[wires[i][1]-1][wires[i][0]-1] = 1;
        }
    }

    private static int dfs(int n, int vertex) {
        visited[vertex] = true;
        int cnt = 1;
        for(int next=0; next<n; next++) {
            if (adj[vertex][next] == 1 && !visited[next]) cnt += dfs(n, next);
        }
        return cnt;
    }




}