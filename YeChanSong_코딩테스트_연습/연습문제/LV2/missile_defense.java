import java.util.*;

class Solution {


    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> {
            return a[1]-b[1];
        });
        int covered = 0;
        for(int i=0;i<targets.length;i++) {
            if (targets[i][0] >= covered) {
                covered = targets[i][1];
                answer += 1;
            }

        }

        return answer;
    }


}