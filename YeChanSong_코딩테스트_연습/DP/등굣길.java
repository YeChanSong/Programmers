class Solution {
    static int[][] cache;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        cache = new int[m][n];
        cache[0][0]=1;
        for(int[] arr: puddles){
            cache[arr[0]-1][arr[1]-1] = -1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cache[i][j]!=-1){
                    if(i>0 && cache[i-1][j] != -1){
                        cache[i][j] += cache[i-1][j];
                        cache[i][j]%=1000000007;
                    }
                    if(j>0 && cache[i][j-1] != -1){
                        cache[i][j] += cache[i][j-1];
                        cache[i][j]%=1000000007;
                    }
                }
            }
        }
        answer = cache[m-1][n-1]%1000000007;
        return answer;
    }
}