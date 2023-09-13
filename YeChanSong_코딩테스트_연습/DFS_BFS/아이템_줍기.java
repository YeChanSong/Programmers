import java.util.*;

class Solution {

    private static int[] moveY = {-1,0,1,0};
    private static int[] moveX = {0,-1,0,1};
    private static HashMap<String, Integer> visited = new HashMap<>();

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        bfs(characterY, characterX, rectangle);
        answer = visited.get(itemY + " " + itemX);
        return answer;
    }

    private void bfs(int startY, int startX, int[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited.put(startY + " " + startX, 0);
        queue.offer(new int[] {startY, startX});

        while(!queue.isEmpty()) {

            int[] currentPos = queue.poll();
            String currentPosStr = currentPos[0] + " " + currentPos[1];
            for(int i=0;i<4;i++) {
                int[] nextPos = new int[] {currentPos[0]+moveY[i], currentPos[1]+moveX[i]};
                double[] nextStep = new double[] {currentPos[0]+(double)moveY[i]/2, currentPos[1]+(double)moveX[i]/2};
                String nextPosStr = nextPos[0] + " " + nextPos[1];
                if (visited.get(nextPosStr) == null &&
                        isOuterLine(nextStep, board)) {
                    visited.put(nextPosStr, visited.get(currentPosStr) +1);
                    queue.offer(nextPos);
                }
            }

        }


    }

    private boolean isOuterLine(double[] nextPos, int[][] board) {
        // nextPos: y,x
        int outerCount = 0;
        for(int i=0;i<board.length; i++) {
            int[] rec = board[i]; // [llx, lly, urx, ury]
            // outer check
            if ((nextPos[0] < (double)rec[1] || nextPos[0] > (double)rec[3])
                    || (nextPos[1] < (double)rec[0] || nextPos[1] > (double)rec[2])) outerCount++;

            // inner check
            if ((nextPos[0] < (double)rec[3] && nextPos[0] > (double)rec[1])
                    && (nextPos[1] < (double)rec[2] && nextPos[1] > (double)rec[0])) return false;
        }

        return outerCount != board.length;
    }
}