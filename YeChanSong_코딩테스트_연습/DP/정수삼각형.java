class Solution {
    static int[][] cache;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        cache= new int[N][N];
        cache[N-1] = triangle[N-1];
        for(int i=N-2;i>-1;i--){
            for(int j=0;j<=i;j++){
                cache[i][j] = Math.max(cache[i+1][j], cache[i+1][j+1]) + triangle[i][j];
            }
        }
        answer = cache[0][0];
        return answer;
    }
}