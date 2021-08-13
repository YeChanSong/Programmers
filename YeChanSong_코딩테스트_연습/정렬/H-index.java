import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, cnt=0, n = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<citations[n-1];i++){
            cnt=0;
            for(int j=0; j<n; j++){
                if(citations[j]>=i)
                    cnt++;
                if(cnt==i)
                    break;
            }
            if(cnt<i)
                break;
            answer =i;
        }
        return answer;
    }
}