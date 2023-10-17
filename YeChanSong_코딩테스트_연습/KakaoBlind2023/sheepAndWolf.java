import java.util.*;

class Solution {

    private static ArrayList<ArrayList<Integer>> adj;
    private static int[] swCosts;
    private static ArrayList<Integer> targetNodes;
    private static int maxSheep = 1;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        setting(info, edges);
        bfs();
        answer = maxSheep;
        return answer;
    }
    private static void setting(int[] info, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0;i<info.length;i++) adj.add(new ArrayList<>());
        targetNodes = new ArrayList<>();
        swCosts = info.clone();
        for(int i=0;i<edges.length;i++) adj.get(edges[i][0]).add(edges[i][1]);
    }

    private static void bfs() {
        ArrayDeque<Man> q = new ArrayDeque<>();
        boolean[] visited = new boolean[swCosts.length];
        visited[0] = true;
        q.offerLast(new Man(1, 0, 0, visited));

        while(!q.isEmpty()) {
            Man curr = q.pollFirst();
            if (curr.sCost <= curr.wCost) continue;
            ArrayList<Integer> adjNode = adj.get(curr.pos);
            for(int i = 0; i < adjNode.size(); i++) {
                int next = adjNode.get(i);

                if (curr.visited[next]) {
                    q.offerLast(new Man(curr.sCost, curr.wCost, next, curr.visited));
                    continue;
                }

                if (swCosts[next] == 0) {
                    curr.visited[next] = true;
                    q.offerLast(new Man(curr.sCost+1, curr.wCost, 0, curr.visited));
                    curr.visited[next] = false;
                    maxSheep = Math.max(maxSheep, curr.sCost+1);
                }
                if (swCosts[next] == 1) {
                    curr.visited[next] = true;
                    q.offerLast(new Man(curr.sCost, curr.wCost+1, 0, curr.visited));
                    curr.visited[next] = false;
                }
            }
        }
    }
}

class Man {
    int sCost;
    int wCost;
    int pos;
    boolean[] visited;
    Man(int s, int w, int p, boolean[] v) {
        this.sCost = s;
        this.wCost = w;
        this.pos = p;
        this.visited = v.clone();
    }
}