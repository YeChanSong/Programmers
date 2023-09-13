import java.util.*;
import java.io.*;

class Solution {
    private static int[] visitCount;
    private static int[] eachBfsResult;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int totalVisitCount = 1;

    public int solution(int n, int[][] results) {
        int answer = 0;

        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());

        Arrays.stream(results).forEach( (result) -> {
            adj.get(result[0]).add(result[1]);
        });

        visitCount = new int[n+1];
        eachBfsResult = new int[n+1];

        for(int i=1;i<n+1;i++) bfs(n, i);
        for(int i=1;i<n+1;i++) {
            if (visitCount[i] + eachBfsResult[i] == n+1) answer++;
        }

        return answer;
    }

    private void bfs(int n, int start) {
        totalVisitCount = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[n+1];
        visited[start] = true;
        visitCount[start]++;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            adj.get(current).forEach( (next) -> {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    totalVisitCount+=1;
                    visitCount[next]++;
                }
            });
        }

        eachBfsResult[start] = totalVisitCount;

    }
}