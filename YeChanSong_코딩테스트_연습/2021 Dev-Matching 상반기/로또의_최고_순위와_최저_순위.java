import java.util.*;

class Solution {
    static int min=6,max=1,curr=0,zcnt=0;
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                zcnt++;
                continue;
            }
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    curr++;
                    break;
                }
            }
        }
        if(curr==0 || curr==1){
            min=6;
        }
        else{
            min = 7-curr;
        }
        curr +=zcnt;
        if(curr==0 || curr==1){
            max=6;
        }
        else{
            max = 7-curr;
        }
        answer = new int[]{max,min};
        return answer;
    }
}