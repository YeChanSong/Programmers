import java.util.*;

class Solution {
    static int[][] board;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[] Y = {0,1,0,-1}, X = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int num=1;
        board = new int[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                board[i][j] = num++;
        
        for(int[] query: queries)
            rotating(query);
        answer = ans.stream().mapToInt(a -> a).toArray();
        return answer;
    }
    public void rotating(int[] query){
        int sy = query[0]-1, sx = query[1]-1, dy = query[2]-1, dx = query[3]-1;
        ArrayList<Integer> nums = new ArrayList<>();
        int y = sy, x = sx, lim = 2*(dy-sy+1) + 2*(dx-sx+1) - 4, dir=0;
        while(lim>0){
            nums.add(board[y][x]);
            if(y+Y[dir]>dy || y+Y[dir]<sy || x+X[dir]>dx || x+X[dir]<sx){
                dir++;
                dir%=4;
            }
            y+=Y[dir]; x+=X[dir];
            lim--;
        }
        lim = 2*(dy-sy+1) + 2*(dx-sx+1) - 4; dir=0; y = sy; x = sx+1;
        ans.add(Collections.min(nums));
        int idx=0;
        while(lim>0){
            board[y][x] = nums.get(idx++);
            if(y+Y[dir]>dy || y+Y[dir]<sy || x+X[dir]>dx || x+X[dir]<sx){
                dir++;
                dir%=4;
            }
            y+=Y[dir]; x+=X[dir];
            lim--;
        }
        
    }
}