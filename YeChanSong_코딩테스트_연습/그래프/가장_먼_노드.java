import java.io.*;
import java.util.*;

class Solution {

    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] dist;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.sort(edge, (a, b) -> {
            if (a[0] == b[0]) return a[1]-b[1];
            else return a[0] - b[0];
        });
        for (int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        Arrays.stream(edge).forEach((e) -> {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        });
        bfs(1);
        int maxValue = Arrays.stream(dist).filter((d) -> { return d < Integer.MAX_VALUE;}).max().getAsInt();
        answer = (int)Arrays.stream(dist).filter( (d) -> {return d == maxValue;}).count();
        return answer;
    }

    private void bfs(int startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startVertex);
        dist[startVertex] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            adj.get(currentVertex).forEach( (next) -> {
                if(dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[currentVertex] +1;
                    queue.offer(next);
                }
            });
        }

    }
}