import java.util.*;

class Solution {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int h=0;h<=citations.length;h++) {
            for(int j=0;j<citations.length;j++) {
                if (citations[j] >= h && citations.length-j >= h) {
                    answer = h;
                    break;
                }
            }
        }
        return answer;
    }
}