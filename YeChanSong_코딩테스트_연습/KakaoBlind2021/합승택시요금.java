import java.util.*;

class Solution {
    static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    static int N, S, A, B;
    static long[][] dist;
    static int answer=0;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N=n;S=s-1;A=a-1;B=b-1;
        dist = new long[N][N];
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                if(i==j)
                    dist[i][j] = 0L;
                else
                    dist[i][j] = 987654321L;
        
        for(int[] sdc: fares){
            // adj.get(sdc[0]-1).add(new int[]{sdc[2],sdc[1]-1}); // cost, dest
            // adj.get(sdc[1]-1).add(new int[]{sdc[2],sdc[0]-1});
            dist[sdc[0]-1][sdc[1]-1] = (long)sdc[2];
            dist[sdc[1]-1][sdc[0]-1] = (long)sdc[2];
        }
        floyd();
        long mSum = dist[S][A] + dist[S][B];
        for(int i=0;i<N;i++){
            mSum = Math.min(mSum, dist[S][i]+dist[i][A]+dist[i][B]);
        }
        answer = (int)mSum;
        return answer;
    }
    public void floyd(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                if(k==i)
                    continue;
                for(int j=0;j<N;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}