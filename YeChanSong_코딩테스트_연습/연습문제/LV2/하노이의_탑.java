import java.util.*;

class Solution {
    private static ArrayDeque<int[]> moveHistory = new ArrayDeque<>();

    public int[][] solution(int n) {
        moveDisk(1, 3, n);
        int[][] answer = new int[moveHistory.size()][];
        int moveCount = moveHistory.size();
        for(int i=0;i<moveCount;i++){
            answer[i] = moveHistory.pollFirst();
        }

        return answer;
    }

    private void moveDisk(int start, int dest, int targetDisk) {
        if (targetDisk == 0) return;
        int tempColumn = 6 - start - dest;
        moveDisk(start, tempColumn, targetDisk-1);
        moveHistory.offerLast(new int[] {start, dest});
        moveDisk(tempColumn, dest, targetDisk-1);
    }
}