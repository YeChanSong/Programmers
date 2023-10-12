import java.util.*;

class Solution {
    private static int[] moveY = {1,0,-1};
    private static int[] moveX = {0,1,-1};
    private static int[][] board;
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        board = new int[n][];
        for(int i=0;i<n;i++) board[i] = new int[i+1];
        int direction = 0;
        board[0][0] = 1;
        int num = 2;
        int y=0, x=0;
        while(true) {
            int nextY = y+moveY[direction];
            int nextX = x+moveX[direction];
            if (num > (n*(n+1))/2) break;
            if (nextY < 0 || nextX < 0
                    || nextY >= n || nextX >= n
                    || board[nextY][nextX] != 0)
            {
                direction = (++direction)%3;
                continue;
            }
            board[nextY][nextX] = num++;
            y = nextY;
            x = nextX;
        }
        int idx= 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++) {
                answer[idx] = board[i][j];
                idx++;
            }
        }
        return answer;
    }

}